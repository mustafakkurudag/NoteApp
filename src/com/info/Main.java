package com.info;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int not;
        int selection = 9;
        int deleteOption;
        int deleteNoteSelection;
        List<String> optionList = new ArrayList<>();
        List<Integer> notList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        //optionList'i dolduruyoruz
        optionList.add("1 - Not Ekle");
        optionList.add("2 - Notları Görüntüle");
        optionList.add("3 - Not Sil");
        optionList.add("0 - Çıkış Yap");

        /**
         *   System.out.println();//parantez içindeki değer ekrana yazıldıktan sonra imleç bir alt satıra iner
         *   System.out.print("");//parantez içindeki değer ekrana yazıldıktan sonra imleç aynı satırda kalmaya devam  eder.
         */

        System.out.println("Hoşgeldiniz...");

        while (selection != 0) {
            //for foreach
            for (int i = 0; i < optionList.size(); i++) {
                System.out.println(optionList.get(i));
            }

            System.out.println("Lütfen seçim yapınız: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    System.out.print("Lütfen not giriniz: ");
                    not = scanner.nextInt();
                    notList.add(not);
                    System.out.println("Not başarıyla kaydedildi!");
                    break;
                case 2:
                    System.out.print("Notlar: ");
                    for (int n : notList) {
                        System.out.print(n + ", ");
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Uygulamadan çıkılıyor...");
                    break;
                case 3:
                    System.out.println("1 - Tüm notları sil");
                    System.out.println("2 - Notu seçip sil");
                    deleteOption = scanner.nextInt();
                    if (deleteOption == 1) {
                        notList.clear();
                        System.out.println("Tüm notlar silindi!");
                        break;
                    } else if (deleteOption == 2) {
                        System.out.print("Silmek istediğiniz notu seçiniz: ");
                        System.out.println(notList);
                        deleteNoteSelection = scanner.nextInt();
                        int noteIndex = notList.indexOf(deleteNoteSelection);
                        if (noteIndex != -1) {
                            notList.remove(noteIndex);
                            System.out.println("Girilen not başarıyla silindi!");
                            break;
                        }
                    }
            }
        }

    }
}
