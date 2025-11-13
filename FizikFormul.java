/*
 * Ad Soyad: Zehra ÖZDEMİR
 * Ogrenci No:250541082
 * Tarih:13.11.2025
 * Aciklama: Gorev 2 - Fizik Formulu Asistani
 *
 * Bu program temel fizik formullerini kullanarak
 * hesaplamalar yapar.
 */

import java.util.Scanner;

public class FizikFormul {

    // Sabit: Yercekimi ivmesi
    final static double GRAVITY = 9.8; // m/s²

    // METOT 1: Hız hesapla (v = s / t)
    public static double calculateVelocity(double distance, double time) {
        // v = mesafe / zaman
        if (time == 0) {
            System.out.println("Hata: Zaman sıfır olamaz.");
            return 0.0;
        }
        return distance / time;

    }

    // METOT 2: İvme hesapla (a = Δv / t)
    public static double calculateAcceleration(double velocityChange, double time) {
        // a = hiz degisimi / zaman
        if (time == 0) {
            System.out.println("Hata: Zaman sıfır olamaz.");
            return 0.0;
        }
        return velocityChange / time;
    }

    // METOT 3: Kuvvet hesapla (F = m * a)
    public static double calculateForce(double mass, double acceleration) {
        // F = kutle * ivme
        return mass * acceleration;
    }

    // METOT 4: İş hesapla (W = F * d)
    public static double calculateWork(double force, double distance) {
        // W = kuvvet * mesafe
        return force * distance;
    }

    // METOT 5: Güç hesapla (P = W / t)
    public static double calculatePower(double work, double time) {
        // P = is / zaman
        if (time == 0) {
            System.out.println("Hata: Zaman sıfır olamaz.");
            return 0.0;
        }
        return work / time;
    }

    // METOT 6: Kinetik enerji (KE = 0.5 * m * v²)
    public static double calculateKineticEnergy(double mass, double velocity) {
        // KE = 0.5 * kutle * (hiz * hiz)
        // Math.pow(velocity, 2) kullanabilirsiniz
        return 0.5 * mass * Math.pow(velocity, 2);
    }

    // METOT 7: Potansiyel enerji (PE = m * g * h)
    public static double calculatePotentialEnergy(double mass, double height) {
        // PE = kutle * yercekimi * yukseklik
        return mass * GRAVITY * height ;
    }

    // METOT 8: Momentum (p = m * v)
    public static double calculateMomentum(double mass, double velocity) {
        // p = kutle * hiz
        return mass * velocity;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== FIZIK FORMUL ASISTANI ===");
        System.out.println();

        // TEMEL OLCUMLER
        System.out.println("TEMEL OLCUMLER:");
        System.out.print("Kutle (kg): ");
        double mass = input.nextDouble();

        System.out.print("Mesafe (m): ");
        double distance = input.nextDouble();

        System.out.print("Zaman (s): ");
        double time = input.nextDouble();

        System.out.print("Hiz degisimi (m/s): ");
        double deltaV = input.nextDouble();

        System.out.print("Yukseklik (m): ");
        double height = input.nextDouble();

        // HESAPLAMALARI YAP - Metotlari cagir
        // 1. Hiz (v) hesaplanmali (KE ve Momentum icin gerekli)
        // 2. Ivme (a) hesaplanmali (Kuvvet icin gerekli)
        // 3. Kuvvet (F) hesaplanmali (Is icin gerekli)
        // 4. Is (W) hesaplanmali (Guc icin gerekli)
        // ... digerlerini hesaplayin



        // METOT 1: Hız (v = s/t)
        double velocity = calculateVelocity(distance, time);
        System.out.printf("Hız (v=s/t):          %.2f m/s\n", velocity);

        // METOT 2: İvme (a = Δv/t)
        double acceleration = calculateAcceleration(deltaV, time);
        System.out.printf("İvme (a=Δv/t):         %.2f m/s²\n", acceleration);

        // METOT 3: Kuvvet (F = m*a)
        double force = calculateForce(mass, acceleration);
        System.out.printf("Kuvvet (F=m*a):       %.2f N\n", force); // N: Newton

        // METOT 4: İş (W = F*d)
        double work = calculateWork(force, distance);
        System.out.printf("İş (W=F*d):           %.2f J\n", work); // J: Joule

        // METOT 5: Güç (P = W/t)
        double power = calculatePower(work, time);
        System.out.printf("Güç (P=W/t):          %.2f W\n", power); // W: Watt

        System.out.println("\n--- ENERJİ ve MOMENTUM ---");

        // METOT 6: Kinetik Enerji (KE = 0.5 * m * v²)
        double kineticEnergy = calculateKineticEnergy(mass, velocity);
        System.out.printf("Kinetik Enerji (KE):  %.2f J\n", kineticEnergy); // J: Joule

        // METOT 7: Potansiyel Enerji (PE = m * g * h)
        double potentialEnergy = calculatePotentialEnergy(mass, height);
        System.out.printf("Potansiyel Enerji (PE): %.2f J\n", potentialEnergy); // J: Joule

        // Toplam Enerji
        double totalEnergy = kineticEnergy + potentialEnergy;
        System.out.printf("Toplam Enerji:        %.2f J (KE + PE)\n", totalEnergy);

        // METOT 8: Momentum (p = m * v)
        double momentum = calculateMomentum(mass, velocity);
        // Momentum birimi: kg·m/s
        System.out.printf("Momentum (p=m*v):     %.2f kg·m/s\n", momentum);

        System.out.println("\n=========================================");

        input.close();
    }
}
