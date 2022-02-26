import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Main {
	
	ArrayList<String> codes = new ArrayList<>();
	ArrayList<String> names = new ArrayList<>();
	ArrayList<String> genders = new ArrayList<>();
	ArrayList<String> positions = new ArrayList<>();
	ArrayList<Integer> salaries = new ArrayList<>();
	
	
	public Main() {	
		Scanner scan = new Scanner(System.in);
		
		int menu = -1;
		while(menu>4 || menu<=0) {
			System.out.println("=======PT Mentol=======");
			System.out.println("1. Input Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.print("Input opsi [1-4]: ");
			menu = scan.nextInt();
			scan.nextLine();
		}
		
		
		switch(menu) {
			case 1: {
				inputData();
				menu();
				break;
			}
			case 2:{
				viewData();
				menu();
				break;
			}
			case 3: {
				updateData();
				menu();
				break;
			}
			case 4: {
				deleteData();
				menu();
				break;
			}
				
		}	
		
		
	}
	
	
	void menu() {
		Scanner scan = new Scanner(System.in);
		
		int menu = -1;
		while(menu>4 || menu<=0) {
			System.out.println("=======PT Mentol=======");
			System.out.println("1. Input Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.print("Input opsi [1-4]: ");
			menu = scan.nextInt();
			scan.nextLine();
		}
		
		
		switch(menu) {
		case 1: {
			inputData();
			menu();
			break;
		}
		case 2:{
			viewData();
			menu();
			break;
		}
		case 3: {
			updateData();
			menu();
			break;
		}
		case 4: {
			deleteData();
			menu();
			break;
		}
			
	}	
	}
	
	void inputData() {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		
		String nama = " ";
		while(nama.length()<3) {
			System.out.print("Input nama karyawan [>=3]: ");
			nama = scan.nextLine();
		}
		names.add(nama);
		
		String sex = " ";
		while(!(sex.equals("Laki-laki") || sex.equals("Perempuan"))) {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			sex = scan.nextLine();
		}
		genders.add(sex);
		
		String jabatan = " ";
		while(!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin"))){
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		}
		positions.add(jabatan);
		
		int managerCount = 0;
		int supervisorCount = 0;
		int adminCount = 0;
		
		int gaji = 0;
		if(jabatan.equals("Manager")) {
			gaji = 8000000;
			if(managerCount%3==0 && managerCount!=0) {
				for(int i=0;i<salaries.size()-1;i++) {
					int gajiAkhir = salaries.get(i);
					gajiAkhir *= 1.1;
					salaries.set(i, gajiAkhir);
				}
			}
			managerCount++;
		} else if(jabatan.equals("Supervisor")) {
			gaji = 6000000;
			if(supervisorCount%3==0 && supervisorCount!=0) {
				for(int i=0;i<salaries.size()-1;i++) {
					int gajiAkhir = salaries.get(i);
					gajiAkhir *= 1.75;
					salaries.set(i, gajiAkhir);
				}
			}
			supervisorCount++;
		} if(jabatan.equals("Admin")) {
			gaji = 4000000;
			if(adminCount%3==0 && adminCount!=0) {
				for(int i=0;i<salaries.size()-1;i++) {
					int gajiAkhir = salaries.get(i);
					gajiAkhir *= 1.05;
					salaries.set(i, gajiAkhir);
				}
			}
			adminCount++;
		}
		salaries.add(gaji);
		
		
		char huruf1 = (char)(random.nextInt('Z'-'A') + 'A');
		char huruf2 = (char)(random.nextInt('Z'-'A') + 'A');
		
		String huruf = new StringBuilder().append(huruf1).append(huruf2).append('-').toString();
		String angka = String.format("%04d", random.nextInt(10000));
		
		String kode = huruf + angka;
		codes.add(kode);
		
		
		System.out.println("Berhasil menambahkan karyawan dengan id " + kode);
		System.out.println("ENTER to return"); scan.nextLine();
		menu();
	}
	
	void bubbleSort() {
		for(int i=0;i<codes.size();i++) {
			for(int j=0;j<codes.size()-i-1;j++) {
				if(names.get(j).compareTo(names.get(j+1))>0) {
					Collections.swap(codes, j, j+1);
					Collections.swap(names, j, j+1);
					Collections.swap(genders, j, j+1);
					Collections.swap(positions, j, j+1);
					Collections.swap(salaries, j, j+1);
				}
			}
		}
	}
	
	void viewData() {   
		bubbleSort();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println(String.format("|%-5s|%-10s|%-20s|%-15s|%-15s|%-10s|", "No", "Kode Karyawan", "Nama Karyawan", "Jenis Kelamin", "Jabatan", "Gaji Karyawan"));
		System.out.println("---------------------------------------------------------------------------------------");
		
		if(codes.size()>0) {	
			for(int i=0;i<names.size();i++) {
				System.out.println(String.format("|%5d|%13s|%20s|%15s|%15s|%13d|", i+1, codes.get(i), names.get(i), genders.get(i), positions.get(i), salaries.get(i)));
			}
			System.out.println("---------------------------------------------------------------------------------------");
		}
		
		
		System.out.println("ENTER to continue"); scan.nextLine();
	}
	
	void updateData() {
		Scanner scan = new Scanner(System.in);
		viewData();
		if(codes.size()==0) return;
		
		int indexKey = -1;
		System.out.print("Masukkan nomor karyawan yang ingin diubah: ");
		indexKey = scan.nextInt(); scan.nextLine();	
		indexKey--;
		
		
		
		String kode = " ";
		while(kode.length()!=7) {
			System.out.print("Masukkan kode karyawan baru: ");
			kode = scan.nextLine();
		}
		codes.set(indexKey, kode);
		
		String nama = " ";
		while(nama.length()<3) {
			System.out.print("Input nama karyawan [>=3]: ");
			nama = scan.nextLine();
		}
		names.set(indexKey, nama);
		
		String sex = " ";
		while(!(sex.equals("Laki-laki") || sex.equals("Perempuan"))) {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			sex = scan.nextLine();
		}
		genders.set(indexKey, sex);
		
		String jabatan = " ";
		while(!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin"))){
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		}
		positions.set(indexKey, jabatan);
		
		int gaji;
		System.out.print("Masukkan gaji baru: ");
		gaji = scan.nextInt(); scan.nextLine();
		salaries.set(indexKey, gaji);
		
		System.out.println("ENTER to continue"); scan.nextLine();
		
		
		
		
	}
	
	void deleteData() {
		Scanner scan = new Scanner(System.in);
		
		viewData();
		
		int indexKey = -1;
		System.out.print("Masukkan nomor karyawan yang ingin dihapus: ");
		indexKey = scan.nextInt(); scan.nextLine();	
		indexKey--;
		
		
		codes.remove(indexKey);
		names.remove(indexKey);
		genders.remove(indexKey);
		positions.remove(indexKey);
		salaries.remove(indexKey);
		
		System.out.println("Data Berhasil Dihapus!");
		
		System.out.println("ENTER to continue"); scan.nextLine();
		
	}
	
	
	
	
	public static void main(String[] args) {
		new Main();
	}

}
