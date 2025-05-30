package lr8.Example4;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LinkParser {
    private static final String URL = "https://itlearn.r/first-steps";
    private static final String OUTPUT_FILE = "src/lr8/Example4/links.txt";
    private static final int MAX_RETRIES = 3;
    private static final long RETRY_DELAY_MS = 2000;

    public static void main(String[] args) {
        Document doc = fetchDocumentWithRetries(URL, MAX_RETRIES);
        if (doc == null) {
            System.err.println("Не удалось получить HTML-код страницы после " + MAX_RETRIES + " попыток.");
            return;
        }

        Elements links = doc.select("a[href]");
        saveLinksToFile(links, OUTPUT_FILE);
    }

    private static Document fetchDocumentWithRetries(String url, int maxRetries) {
        int attempts = 0;
        while (attempts < maxRetries) {
            try {
                return Jsoup.connect(url).get();
            } catch (IOException e) {
                attempts++;
                System.err.println("Ошибка подключения (попытка " + attempts + "): " + e.getMessage());
                if (attempts < maxRetries) {
                    try {
                        Thread.sleep(RETRY_DELAY_MS);
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        System.err.println("Прерывание при ожидании повторного подключения.");
                        break;
                    }
                }
            }
        }
        return null;
    }

    private static void saveLinksToFile(Elements links, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Element link : links) {
                String href = link.attr("abs:href");
                writer.write(href);
                writer.newLine();
            }
            System.out.println("Ссылки успешно сохранены в файл: " + filePath);
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
