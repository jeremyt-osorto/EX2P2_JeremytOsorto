/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex2p2_jeremytosorto;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
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
    static Random ran=new Random();
    
    /**
     * @param args the command line arguments
     */
    private static void atraparP(Pokemon atrapar, Trainer ent){
        int atp=ran.nextInt(100)+1, p=1;
        
        
        if (p==2 && ent.getPokeballs()<0){
            System.out.println("No se ha podido atrapar el pokemon");
        }
    }
    
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
                    + "\nIngrese Opcion: ");
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
                    
                    double vida, at, def, c;
                    
                    do{
                        System.out.println("Ingrese vida del pokemon [150-500]");
                        vida=in.nextDouble();
                    }
                    while (vida<150 || vida>500);
                    
                    do{
                        System.out.println("Ingrese ataque de pokemon [80-120]");
                        at=in.nextDouble();
                    }
                    while (at<80 || at>120);
                    
                    do{
                        System.out.println("Ingrese defensa del pokemon [30-50]");
                        def=in.nextDouble();
                    }
                    while (def<30 || def>50);
                    
                    do{
                        System.out.println("Ingresa catch Rate del pokemon [1-100]");
                        c=in.nextDouble();
                    }
                    while(c<1 || c>100);
                    
                    Pokemon ne=new Pokemon(esp, tipo, at, def, c, vida);
                    System.out.println("Pokemon creado correctamente");
                    pokemonCreado.add(ne);
                    
                    break;
                case 2:
                    if (pokemonCreado.isEmpty()){
                        System.out.println("------------------------");
                        System.out.println("No hay pokemones para atrapar");
                        System.out.println("------------------------");
                    }
                    else{
                        System.out.println("ha encontrado un pokemon");
                        int r=ran.nextInt(0,pokemonAtrapado.size());
                        Pokemon atrapar=pokemonAtrapado.get(r);
                        
                        System.out.println("Es un "+atrapar.getNombre()+" salvaje!");
                        System.out.println("Pokebolas : "+ent.getPokeballs());
                        atraparP(atrapar, ent);
                    }
                    break;
                case 3:
                    if (!pokemonCreado.isEmpty()){
                        System.out.println("Seleccione una opcion:\n1- Tipo\n2- Pokemon atrapados\n3- Todos");
                        int opc2=in.nextInt();
                        switch (opc2){
                            case 1:
                                System.out.println("Ingrese tipo:\n1- Fuego\n2- Agua\n3- Planta\nIngrese opcion");
                                int opc3=in.nextInt();
                                String th="";

                                switch (opc3){
                                    case 1:
                                        th="Fuego";
                                        break;
                                    case 2:
                                        th="Agua";
                                        break;
                                    case 3:
                                        th="Planta";
                                        break;
                                    default:
                                        System.out.println("Ingrese un valor admitido");
                                        break;
                                }
                                
                                System.out.println("--------------------------");
                                String flag="";
                                for (int i=0; i<pokemonCreado.size();i++){
                                    String sh=pokemonCreado.get(i).getTipo();

                                    if (sh.equalsIgnoreCase(th)){
                                        System.out.println(pokemonCreado.get(i));
                                        System.out.println("--------------------------");
                                        flag+="1";
                                    }

                                    if(i==(pokemonCreado.size()-1) && flag.isEmpty()){
                                        System.out.println("No se ha encontrado ese tipo");
                                        System.out.println("--------------------------");
                                    }
                                }
                                break;
                            case 2:
                                if (pokemonAtrapado.isEmpty()){
                                    System.out.println("----------------------");
                                    System.out.println("no hay pokemones atrapados");
                                    System.out.println("----------------------");
                                }
                                else {
                                    System.out.println("------------------------");
                                    for (int i=0; i<pokemonAtrapado.size();i++){
                                        System.out.println(pokemonAtrapado.get(i));
                                        System.out.println("------------------------");
                                    }
                                }
                                break;
                            case 3:
                                if (pokemonCreado.isEmpty()){
                                    System.out.println("------------------------");
                                    System.out.println("No hay pokemones creados");
                                    System.out.println("------------------------");
                                }
                                else{
                                    System.out.println("------------------------");
                                    for (int i=0; i<pokemonCreado.size();i++){
                                        System.out.println(pokemonCreado.get(i));
                                        System.out.println("------------------------");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Ingrese una opcion valida");
                                break;
                        }
                    }
                    else{
                        System.out.println("------------------------------------");
                        System.out.println("No hay pokemones creados");
                        System.out.println("------------------------------------");
                    }
                    break;
                case 4:
                    if (pokemonAtrapado.isEmpty()){
                        System.out.println("------------------------");
                        System.out.println("No hay pokemones atrapados");
                        System.out.println("------------------------");
                    }
                    else {
                        System.out.println("Hacelo");
                    }
                    break;
                case 5:
                    System.out.println("------------------------");
                    System.out.println("Ingres el numero de pokebolas que desea comprar");
                    int cant=in.nextInt();
                    
                    if ((cant*100)<=ent.getDinero()){
                        System.out.println("Ha comprado "+cant+" pokebolas!");
                        ent.setPokeballs(ent.getPokeballs()+cant);
                        ent.setDinero(ent.getDinero()-(cant*100));
                    }
                    else{
                        System.out.println("No tiene suficiente dinero");
                    }
                    System.out.println("------------------------");
                    break;
                case 6:
                    System.out.println("------------------------");
                    System.out.println("Nombre : "+ent.getNombre());
                    System.out.println("Region : "+ent.getRegion());
                    System.out.println("Dinero : "+ent.getDinero());
                    System.out.println("pokebolas : "+ent.getPokeballs());
                    System.out.println("------------------------");
                    break;
            }
        }
        while(opc<7);
    }
    
}
