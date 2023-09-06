package sem3.task2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileManager fileManager = new FileManager();
        fileManager.write("newFile.xml", "Content");
        fileManager.read("newFile.xml");
        fileManager.copy("newFile.xml", "anotherFile.xml");
        fileManager.read("anotherFile.xml");

    }
}

class FileManager{
    public void read(String filepath) throws FileNotFoundException{
        File file = new File(filepath);
        if(!file.exists()){
            throw new FileNotFoundException("File not found: " + filepath);
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(String filepath, String content) throws FileNotFoundException{
        File file = new File(filepath);
        if(!file.exists()){
            throw new FileNotFoundException("File not found: " + filepath);
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copy(String sourcePath, String destinationPath) throws FileNotFoundException{
        File sourceFile = new File(sourcePath);
        if(!sourceFile.exists()){
            throw new FileNotFoundException("File not found: " + sourceFile);
        }

        File destinationFile = new File(destinationPath);

        try(InputStream input = new FileInputStream(sourceFile);
        OutputStream output = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1){
                output.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*Задача 2: Файловый менеджер (ООП, исключения)

        Создайте класс FileManager. Этот класс должен иметь методы для выполнения основных операций с файлами:
        чтение, запись и копирование.
        Каждый из этих методов должен выбрасывать соответствующее исключение,
        если в процессе выполнения операции произошла ошибка (например, FileNotFoundException, если файл не найден).*/

