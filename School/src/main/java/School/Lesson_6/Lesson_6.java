package School.Lesson_6;
import java.io.*;

public class Lesson_6 {
    public static void main(String[] args) {
        AppData appData = new AppData();
        appData.setHeader(new String[]{"Column1", "Column2", "Column3"});
        appData.setData(new int[][]{
                {12, 2, 3},
                {42, 52, 6},
                {72, 8, 92}
        });

        appData.save(appData);
        appData.load("Sample.csv");
    }
    public static class AppData {
        private String[] header;
        private int [][] data;
        void setHeader (String[] header){
            this.header = header;
        }
        void setData (int [][] data){
            this.data = data;
        }

        public void save(AppData data) {
            try (FileWriter writer = new FileWriter("Sample.csv")) {
                for (String columnName : data.header) {
                    writer.append(columnName);
                    writer.append(';');
                }
                writer.append('\n');
                for (int[] row : data.data) {
                    for (int value : row) {
                        writer.append(String.valueOf(value));
                        writer.append(';');
                    }
                    writer.append('\n');
                }
                System.out.println("CSV файл Sample.csv был успешно сохранён.");
            } catch (IOException e) {
                System.err.println("Ошибка при сохранении CSV файла: " + e.getMessage());
            }
        }

        public void load(String filename) {
            byte[] buffer = new byte[255];
            try (FileInputStream in = new FileInputStream(filename)) {
                int count;
                while ((count = in.read(buffer)) >0) {
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) buffer[i]);
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}