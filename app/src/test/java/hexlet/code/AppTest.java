package hexlet.code;

import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;

import io.javalin.Javalin;
import io.javalin.testtools.JavalinTest;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {


    private static MockWebServer mockWebServer;
    private static String mockUrl;

    Javalin app;

    @BeforeEach
    public final void setUp() throws IOException, SQLException {
        app = App.getApp();
    }


    @BeforeAll
    public static void beforeAll() throws IOException, SQLException {
        mockWebServer = new MockWebServer();
        Path path  = Paths.get("src/test/resources/fixtures/test.html").toAbsolutePath().normalize();
        MockResponse mockedResponse = new MockResponse()
                .setBody(Files.readString(path));
        mockWebServer.enqueue(mockedResponse);
        mockWebServer.start();
        mockUrl = mockWebServer.url("/").toString();

    }

    @AfterAll
    public static void afterAll() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void testMainPage() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/");
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    void testUrlsPage() throws Exception {

        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls");
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    public void testUrlPage() throws Exception {
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        var url = new Url(mockUrl, createdAt);
        UrlRepository.save(url);
        JavalinTest.test(app, (server, client) -> {
            var response = client.get("/urls/" + url.getId());
            assertThat(response.code()).isEqualTo(200);
        });
    }

    @Test
    public void testCreateUrl() throws Exception {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = mockUrl;
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(200);
            assertThat(response.body().string()).contains(mockUrl);
            assertThat(response.body().string()).contains("Страница успешно добавлена");
        });

    }

    @Test
    public void testAddWrongUrl() throws Exception {
        JavalinTest.test(app, (server, client) -> {
            var requestBody = "example";
            var response = client.post("/urls", requestBody);
            assertThat(response.code()).isEqualTo(400);
            assertThat(response.body().string()).contains("Некорректный URL");
        });

    }

    @Test
    public void testCheckUrl() throws Exception {
        Timestamp createdAt = new Timestamp(System.currentTimeMillis());
        var url = new Url(mockUrl, createdAt);
        UrlRepository.save(url);

        JavalinTest.test(app, (server, client) -> {

            var response = client.post("/urls/" + url.getId() + "/checks");
            assertThat(response.code()).isEqualTo(200);

            assertThat(response.body().string()).contains("Погода в Санкт-Петербурге");
            assertThat(response.body().string()).contains("Погода");
            assertThat(response.body().string()).contains("Текущая погода и точный прогноз");
            assertThat(response.body().string()).contains("Страница успешно проверена");
        });

    }

}
