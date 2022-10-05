package ellian.aragao.com.github;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class AlticciSequenceResourceTest {

    @Nested
    @DisplayName("Should Test the Left and Right Bound of the Sequence")
    class AlticciSequenceResourceBoundsLimitTest {
        @Test
        void testLeftBoundOfAlticciGet() {
            given()
                    .when().get("/alticci/0")
                    .then()
                    .statusCode(200)
                    .body(is("{\"term\":0,\"value\":0}"));
        }

        @Test
        void testRightBoundOfAlticciGet() {
            given()
                    .when().get("/alticci/157")
                    .then()
                    .statusCode(200)
                    .body(is("{\"term\":157,\"value\":8125799229398355841}"));
        }
    }

    @Nested
    @DisplayName("Should Test when is not in the Left and Right Bound of the Sequence")
    class AlticciSequenceResourceBadRequestTest {
        @Test
        void testLessThenLeftBoundOfAlticciGet() {
            given()
                    .when().get("/alticci/-1")
                    .then()
                    .statusCode(400)
                    .body(is("Size must be greater than 0"));
        }

        @Test
        void testBiggerThenRightBoundOfAlticciGet() {
            given()
                    .when().get("/alticci/158")
                    .then()
                    .statusCode(400)
                    .body(is("Size must be less than 158, otherwise it will overflow the Long type"));
        }
    }

}
