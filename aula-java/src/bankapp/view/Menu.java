package bankapp.view;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import bankapp.model.Conta;
import bankapp.controller.ContaService;

public class Menu {
	public void menuGeral() {
		
		int escolha = 0;
		Conta conta = new Conta();
		Conta contaDestino = new Conta();
		ContaService conta1 = new ContaService();
		
		while (escolha != 5) {
			Scanner input = new Scanner(System.in);
			System.out.println(
					"O que deseja fazer?\n 1 - Deposito \n 2 - Saque \n 3 - Transfer�ncia \n 4 - Extrato \n 5 - Sair");
			escolha = input.nextInt();

			switch (escolha) {
			case 1: {
				this.deposito(conta, conta1);
				break;
			}
			case 2: {
				this.saque(conta, conta1);
				break;
			}
			case 3: {
				this.transferencia(contaDestino, conta1, conta);
				break;
			}
			case 4: {
				this.extrato(conta, conta1, contaDestino);
			}
			
			default:
				System.out.println("Opera��o cancelada pelo usu�rio!");
			}
		}
		System.out.println("Opera��o cancelada pelo usu�rio!");
		
	}

	public void deposito(Conta conta, ContaService conta1) {
		System.out.println("Qual valor deseja depositar? \n");
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.ENGLISH);
		double deposito;
		deposito = input.nextDouble();
		if (deposito > 0) {
			conta1.depositar(conta, deposito);
			System.out.println("Deposito de R$ " +deposito+  " realizado com sucesso! ");
			System.out.println("Voc� retornar� para o menu principal!");
		} else {
			System.out.println("Saldo insuficiente para esta transa��o!");
		}
	}
	public void saque(Conta conta, ContaService conta1) {
		System.out.println("Qual valor deseja sacar? \n");
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.ENGLISH);
		
		int saque;
		saque = (int) input.nextDouble();
		if (saque <= conta.getSaldo()) {
			conta1.sacar(conta, saque);
			System.out.println("Saque de R$ " +saque+  " realizado com sucesso! ");
			System.out.println("Voc� retornar� para o menu principal! ");
			
			
		}else if(saque > conta.getSaldo()) {
			conta1.sacar(conta, saque);
			System.out.println("Saldo insuficiente para esta transa��o! Voc� retornar� para o menu principal!");
		}else {
			System.out.println(" ");
		}
	}
	public void transferencia(Conta conta, ContaService conta1, Conta contaDestino) {
		System.out.println("Qual valor deseja transferir? \n");
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.ENGLISH);
		double transferencia;
		transferencia = input.nextDouble();
		if (transferencia <= conta.getSaldo()) {
			conta1.transferir(conta, transferencia, contaDestino);
			System.out.println("Transfer�ncia de R$" + transferencia + " realizada com sucesso!");
			System.out.println("Voc� retornar� para o menu principal!");
		} else {
			System.out.println("Saldo insuficiente para esta transa��o!");
		}
	}
	
	public void extrato(Conta conta, ContaService conta1, Conta contaDestino) {
		
		 System.out.println("------------------------Extrato----------------------------------------------------");
		
		DateTimeFormatter hora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Data da requisi��o: "+hora.format(LocalDateTime.now()));
        String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

        System.out.println(timeStamp);
		
		    System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Saldo: " + conta.getSaldo());
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("Agradecemos por utilizar o Banco G3. O menu principal ficar� abaixo � sua disposi��o! ");
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("................... ....................................O Banco G3 deseja boas festas! ");
            System.out.println("---------------------------------------------------------------------------------------");
            
       }

		
	}
	
	
		
	

	
	

