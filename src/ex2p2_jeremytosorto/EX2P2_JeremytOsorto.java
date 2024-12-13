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
    static int tam=pokemonCreado.size();
    static int r=ran.nextInt(tam);
    
    /**
     * @param args the command line arguments
     */
    private static String atraparP(Pokemon atrapar, Trainer ent, int p){
        double atp=ran.nextDouble(100)+1;
        ent.setPokeballs(ent.getPokeballs()-1);
        
        if (p==0 || ent.getPokeballs()<0){
            System.out.println("No se ha podido atrapar el pokemon");
            return "";
        }
        if (atp<=atrapar.getCatchRate()){
            pokemonAtrapado.add(atrapar);
            System.out.println("Se pudo atrapar el "+atrapar.getNombre()+" salvaje!");
            return "";
        }
        else{
            System.out.println("El "+atrapar.getNombre()+" salvaje escapo de la pokebola! deseas intentar otra vez? (1-si, 0-no)");
            System.out.println("Pokebolas : "+ent.getPokeballs());
            p=in.nextInt();
            return atraparP(atrapar, ent, p);
        }
        
    }
    
    private static void batalla(Pokemon atta, Pokemon deff, boolean turno, Trainer ent){
        
        if (atta.getVida()<=0){
            System.out.println("Tu pokemon ha sido derrotado :(");
            ent.setDinero(ent.getDinero()-1000);
            atta.setNivel(atta.getNivel()-3);
            
            if (ent.getDinero()<0){
                ent.setDinero(0);
            }
            if (atta.getNivel()<1){
                atta.setNivel(1);
            }
        }
        
        if (deff.getVida()<=0){
            System.out.println("El pokemon salvaje ha sido derrotado");
            int subn=ran.nextInt(1,4);
            atta.setNivel(atta.getNivel()+subn);
            ent.setDinero(ent.getDinero()+ran.nextInt(600,801));
        }
        
        double da=cal(deff, atta, turno);
        
        if (turno){
            deff.setVida(deff.getVida()-da);
            System.out.println(atta.getNombre()+" ataca a "+deff.getNombre()+" y recibe "+da+" de daño");
        }
        else{
            da=cal(atta,deff,!turno);
            atta.setVida(atta.getVida()-da);
            System.out.println(deff.getNombre()+" ataca a "+atta.getNombre()+" y recibe "+da+" de daño");
        }
        
        batalla(atta, deff, !turno,ent);
    }
    
    private static double cal(Pokemon ata, Pokemon def, boolean turno){
        double dab= ata.getAtaque()+20*ata.getNivel()-def.getDefensa()/2;
        double daf=dab;
        
        String tip=ata.getTipo();
        String tip1=def.getTipo();
        
        if ((tip.equalsIgnoreCase("Fuego") && tip1.equalsIgnoreCase("Planta")) || (tip.equalsIgnoreCase("Planta") && tip1.equalsIgnoreCase("Agua")) || (tip.equalsIgnoreCase("Agua") && tip1.equalsIgnoreCase("Fuego"))){
            daf*=1.5;
        }
        else if ((tip1.equalsIgnoreCase("Fuego") && tip.equalsIgnoreCase("Planta")) || (tip1.equalsIgnoreCase("Planta") && tip.equalsIgnoreCase("Agua")) || (tip1.equalsIgnoreCase("Agua") && tip.equalsIgnoreCase("Fuego"))){
            daf/=2;
        }
        
        if (daf<0){
            daf=0;
        }
        
        return daf;
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
                        int p=1;
                        Pokemon atrapar=pokemonCreado.get(r);
                        
                        System.out.println("Es un "+atrapar.getNombre()+" salvaje!");
                        System.out.println("Pokebolas : "+ent.getPokeballs());
                        atraparP(atrapar, ent, p);
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
                    else if (pokemonCreado.size()<2){
                        System.out.println("-------------------------------------------");
                        System.out.println("Debe tener dos o mas pokemones creados");
                        System.out.println("-------------------------------------------");
                    }
                    else {
                        System.out.println("-------------------------------------------");
                        System.out.println("Ingrese el indice del pokemon a entrenar");
                        int int1=in.nextInt();
                        
                        if (int1<0 || int1>=pokemonAtrapado.size()){
                            System.out.println("Ingrese un indice valido");
                        }
                        
                        Pokemon selec=pokemonAtrapado.get(int1);
                        Pokemon cont=pokemonCreado.get(r);
                        
                        System.out.println("Tu batalla es contra "+cont.getNombre()+" salvaje!");
                        batalla(selec, cont, true, ent);
                        
                        System.out.println("-------------------------------------------");
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
