package AudiTicketBook;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public interface Savable {
        public static void readFromMemory() throws IOException {

        }
        public static void writeToMemory() throws IOException {

        }
        public static List<Object> getAllInstances(){
                return null;
        }
}
