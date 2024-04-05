package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Singleton tasarım deseni
class FileReaderSingleton {
    private static FileReaderSingleton instance;
    private BufferedReader bufferedReader;

    private FileReaderSingleton(String dosyaYolu) throws IOException {
        FileReader fileReader = new FileReader(dosyaYolu);
        bufferedReader = new BufferedReader(fileReader);
    }

    public static FileReaderSingleton getInstance(String dosyaYolu) throws IOException {
        if (instance == null) {
            instance = new FileReaderSingleton(dosyaYolu);
        }
        return instance;
    }

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    public void close() throws IOException {
        bufferedReader.close();
    }
}

public class FileReadingSingletonExample {
    public static void main(String[] args) {
        try {
            // Singleton kullanarak dosya okuma
            FileReaderSingleton fileReader = FileReaderSingleton.getInstance("ornek.txt");

            String satir;
            // Dosya sonuna kadar oku ve ekrana yazdır
            while ((satir = fileReader.readLine()) != null) {
                System.out.println(satir);
            }

            // Singleton sınıfını kapat
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Dosya okuma sırasında bir hata oluştu: " + e.getMessage());
        }
    }
}
