package com.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> optionList = new ArrayList<>();
    public static void main(String[] args) {
        int not;
        int selection = 9;
        List<Integer> notList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        optionList.add("0 - Çıkış Yap");
        optionList.add("1 - Not Ekle");
        optionList.add("2 - Notları Görüntüle");
        optionList.add("3 - Not Sil");
        optionList.add("4 - Not Ortalamasını Hesapla");

        System.out.println("Hoşgeldiniz...");

        while (selection != 0) {
            //for foreach
            showMenu(optionList);

            System.out.println("Lütfen seçim yapınız: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 0:
                    System.out.println("Uygulamadan çıkılıyor...");
                    break;
                case 1:
                    notList = saveExamScores(notList);
                    break;
                case 2:
                    showAllExamScores(notList);
                    break;
                case 3:
                    notList = deleteNotes(notList);
                    break;
                case 4:
                    double average = calculateAverage(notList);
                    System.out.print("Girilen notların ortalaması: " + average);
                    System.out.println("");
                    break;
            }
        }
    }

    /**
     * public static int findSumUsingStream(int[] array) {
     *     return Arrays.stream(array).sum();
     * }
     */
    private static List<Integer> saveExamScores(List<Integer> examScoreList) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Lütfen not giriniz: ");
        int examScore = scan.nextInt();
        examScoreList.add(examScore);
        System.out.println("Not başarıyla kaydedildi!");

        return examScoreList;
    }
    private static void showAllExamScores(List<Integer> examScoreList) {
        System.out.print("Notlar: ");
        System.out.println(examScoreList);
    }
    private static List<Integer> deleteNotes(List<Integer> examScoreList) {
        System.out.println("1 - Tüm notları sil");
        System.out.println("2 - Notu seçip sil");
        /** new */System.out.println("3 - Ana menü");
        Scanner scan = new Scanner(System.in);
        int deleteOption = scan.nextInt();
        if (deleteOption == 1) {
            examScoreList.clear();
            System.out.println("Tüm notlar silindi!");
        } else if (deleteOption == 2) {
            System.out.print("Silmek istediğiniz notu seçiniz: ");
            System.out.println(examScoreList);
            int deleteNoteSelection = scan.nextInt();
            int noteIndex = examScoreList.indexOf(deleteNoteSelection);
            if (noteIndex != -1) {
                examScoreList.remove(noteIndex);
                System.out.println("Girilen not başarıyla silindi!");
            } else if(deleteOption == 3) {
                showMenu(optionList);
            } else {
                System.out.println("Lütfen geçerli bir seçim yapınız!");
                deleteNotes(examScoreList);
            }
        }

        return examScoreList;
    }
    private static double calculateAverage(List<Integer> examScores) {
        double average = 0.0;
        int sum = 0;

        for (int not: examScores){
            sum += not;
        }

        average = sum / examScores.size();

        return average;
    }

    private static void showMenu(List<String> options) {
        for (String option : options) {
            System.out.println(option);
        }
    }


}
