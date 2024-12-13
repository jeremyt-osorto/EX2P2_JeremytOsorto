/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2p2_jeremytosorto;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class EX2P2_JeremytOsorto {
    
    static ArrayList<Pokemon> pokemonCreado=new ArrayList();
    static ArrayList<Pokemon> pokemonAtrapado=new ArrayList();
    static Trainer train=new Trainer();
    static Scanner lee=new Scanner(System.in);
    static Scanner in=new Scanner(System.in);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nom, reg;
        int opc=0;
        
        System.out.println("Ingrese nombre de entrenador:");
        nom=lee.nextLine();
        System.out.println("Ingrese region de entrenador:");
        reg=lee.nextLine();
        
        Trainer ent=new Trainer(nom,reg);
        
        do{
            System.out.println("Entrenador : "+nom+"\nRegion : "+reg+"\nDinero : "+ent.getDinero()+"\nPokebolas : "+ent.getPokeballs()+"\n-------------------------------------------"
                    +"\n1) Crear Pokemon\n2) Atrapar Pokemon\n3) Pokedex\n4) Entrenar Pokemon\n5) Comprar Pokebolas\n6) Informacion del Entrenador\n7) Salir"
                    + "Ingrese Opcion: ");
            opc=in.nextInt();
            
            switch (opc){
                case 1:
                    System.out.println("Ingrese especie de pokemon: ");
                    String esp=lee.nextLine();
                    System.out.println("Ingrese tipo de pokemon:\n1- Fuego\n2- Agua\n3- Planta\nIngrese opcion: ");
                    int t;
                    String tipo="";
                    
                    do{
                        t=in.nextInt();
                        switch (t){
                            case 1:
                                tipo="Fuego";
                                break;
                            case 2:
                                tipo="Agua";
                                break;
                            case 3:
                                tipo="Planta";
                                break;
                            default:
                                System.out.println("Ingrese un valor correcto");
                                break;
                        }
                    }
                    while (tipo.equalsIgnoreCase(""));
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
            }
        }
        while(opc<7);
    }
    
}
