/*
 * Ad Soyad: Zehra ÖZDEMİR
 * Ogrenci No: 250541082
 * Tarih: 13.11.2025
 * Aciklama: Gorev 3 - E-Ticaret Sepet Hesaplayici
 *
 * Bu program 3 adet urunun sepet tutarini
 * KDV, indirim ve kargo dahil hesaplar.
 */

import java.util.Scanner;

public class SepetHesap {

    // Sabitler Tanımlama
    // KDV Oranı (%18)
    public static final double VAT_RATE = 0.18;
    // Sabit kargo ücreti (TL)
    public static final double SHIPPING_FEE = 29.99;

    // METOT 1: Bir ürünün toplam fiyatını hesaplar (fiyat * adet)
    public static double calculateLineTotal(double price, int quantity) {
        // Satır Toplamı = fiyat * adet
        return price * quantity;
    }

    // METOT 2: Sepetteki 3 ürünün ara toplamını hesaplar
    // Ara Toplam = SatışTop_1 + SatışTop_2 + SatışTop_3
    public static double calculateSubtotal(double line1, double line2, double line3) {
        return line1 + line2 + line3;
    }

    // METOT 3: İndirim tutarını hesaplar
    // İndirim Tutarı = Ara Toplam * (% / 100)
    public static double calculateDiscountAmount(double subtotal, double discountPercent) {
        // discountPercent'in % olarak girildiği varsayılmıştır (örneğin 10 veya 20)
        return subtotal * (discountPercent / 100.0);
    }

    // METOT 4: İndirimli fiyatı hesaplar
    // İndirimli Toplam = Ara Toplam - İndirim Tutarı
    public static double applyDiscount(double subtotal, double discountAmount) {
        return subtotal - discountAmount;
    }

    // METOT 5: KDV tutarını hesaplar (İndirimli toplam üzerinden)
    // KDV Tutarı = İndirimli Toplam * VAT_RATE
    public static double calculateVAT(double discountedTotal, double vatRate) {
        return discountedTotal * vatRate;
    }

    // METOT 6: Genel toplamı hesaplar
    // Genel Toplam = İndirimli Toplam + KDV + Kargo
    public static double calculateGrandTotal(double discountedTotal, double vatAmount, double shippingFee) {
        return discountedTotal + vatAmount + shippingFee;
    }

    // --- MAIN FONKSİYON ---
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== E-TİCARET SEPET HESAPLAYICI ===");
        System.out.println("\nLütfen 3 ürünün bilgilerini girin:");

        // URUN 1 Bilgileri
        System.out.println("\nURUN 1:");
        System.out.print(" Birim Fiyat (TL): ");
        double price1 = input.nextDouble();
        System.out.print(" Adet: ");
        int qty1 = input.nextInt();

        // URUN 2 Bilgileri
        System.out.println("\nURUN 2:");
        System.out.print(" Birim Fiyat (TL): ");
        double price2 = input.nextDouble();
        System.out.print(" Adet: ");
        int qty2 = input.nextInt();

        // URUN 3 Bilgileri
        System.out.println("\nURUN 3:");
        System.out.print(" Birim Fiyat (TL): ");
        double price3 = input.nextDouble();
        System.out.print(" Adet: ");
        int qty3 = input.nextInt();

        // İndirim Bilgisi
        System.out.println("\nİndirim Kuponu Yüzdesi (%): ");
        double discountPercent = input.nextDouble();

        // --- HESAPLAMALARI YAP - Metotları Çağır ---

        // 1. Ürünlerin satış toplamlarını hesapla
        double lineTotal1 = calculateLineTotal(price1, qty1);
        double lineTotal2 = calculateLineTotal(price2, qty2);
        double lineTotal3 = calculateLineTotal(price3, qty3);

        // 2. Ara toplamı hesapla
        double subtotal = calculateSubtotal(lineTotal1, lineTotal2, lineTotal3);

        // 3. İndirim tutarını hesapla
        double discountAmount = calculateDiscountAmount(subtotal, discountPercent);

        // 4. İndirimli toplamı hesapla (Bu adım videoda atlanmış ancak genel toplam için gerekli)
        double discountedTotal = applyDiscount(subtotal, discountAmount);

        // 5. KDV tutarını hesapla (İndirimli toplam üzerinden)
        double vatAmount = calculateVAT(discountedTotal, VAT_RATE);

        // 6. Genel toplamı hesapla
        double grandTotal = calculateGrandTotal(discountedTotal, vatAmount, SHIPPING_FEE);

        // --- SONUÇLARI YAZDIR ---
        System.out.println("\n==================================");
        System.out.println("       📝 SİPARİŞ ÖZETİ");
        System.out.println("==================================");

        // Ürün Satır Toplamları
        System.out.printf("Ürün 1 Toplamı (%.2f TL x %d Adet): %.2f TL%n", price1, qty1, lineTotal1);
        System.out.printf("Ürün 2 Toplamı (%.2f TL x %d Adet): %.2f TL%n", price2, qty2, lineTotal2);
        System.out.printf("Ürün 3 Toplamı (%.2f TL x %d Adet): %.2f TL%n", price3, qty3, lineTotal3);

        System.out.println("----------------------------------");

        // Ara Toplam
        System.out.printf("Ara Toplam Tutarı: %.2f TL%n", subtotal);

        // İndirim Tutarı
        System.out.printf("İndirim Tutarı (%%%d): -%.2f TL%n", (int)discountPercent, discountAmount);

        System.out.println("----------------------------------");

        // İndirimli Toplam
        System.out.printf("İndirimli Toplam: %.2f TL%n", discountedTotal);

        // KDV Tutarı
        System.out.printf("KDV Tutarı (%%%d): +%.2f TL%n", (int)(VAT_RATE * 100), vatAmount);

        // Kargo Ücreti
        System.out.printf("Kargo Ücreti: +%.2f TL%n", SHIPPING_FEE);

        System.out.println("==================================");

        // GENEL TOPLAM
        System.out.printf("💳 GENEL TOPLAM: %.2f TL%n", grandTotal);

        System.out.println("==================================");


        input.close();
    }
}
