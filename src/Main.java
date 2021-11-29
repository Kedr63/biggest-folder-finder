import java.io.File;

public class Main {
    public static void main(String[] args) {
        String folderPath = "/Users/aleksandrshabalin/Desktop/подкасты в дорогу дек14";
        File file = new File(folderPath);
        /*System.out.println(file.length()); // (238 byte) т/к это директория, то размер будет не настоящий*/
        System.out.println(getFolderSize(file));
    }

    // создадим рекурсивный метод
    public static long getFolderSize(File folder) {
        if (folder.isFile()) {  // если это файл
            return folder.length(); // то вернет размер файла
        }
        // далее получим список файлов в этой папке
        long sum = 0;
        File[] files = folder.listFiles();
        for (File file : files) {
            sum += getFolderSize(file);
        }
        return sum;
    }
}
