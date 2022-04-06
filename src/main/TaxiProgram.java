
package main;

public class TaxiProgram {

    public static void main(String[] args) {
        Fuvar[] Fuvar = new Fuvar[5];
        Fuvar f1 = new Fuvar("kp","VW",120,27500,"ABC-123");
        Fuvar f2 = new Fuvar("kp","BMW",12,1350,"QWE-123");
        Fuvar f3 = new Fuvar("kp","VW",43,8750,"ABC-123");
        Fuvar f4 = new Fuvar("kártya","VW",53,9520,"ABC-123");
        Fuvar f5 = new Fuvar("utalás","Opel",23,5200,"ASD-123");
        
        Fuvar[0] = f1;
        Fuvar[1] = f2;
        Fuvar[2] = f3;
        Fuvar[3] = f4;
        Fuvar[4] = f5;
//        Fuvar[0].kiir();
        //Privát adattagok esetében függvények által visszakapott adatokat alkalmazunk
        //Publikus adattagos megoldások:
        //1.Átlag
        int ossz = 0;
        for (int i = 0; i < Fuvar.length; i++) {
            ossz+= Fuvar[i].osszeg;
        }
        System.out.println("Átlag bevétel: "+ossz/Fuvar.length);
        //2.ABC-123 rendszámú fuvaros átlag bevétele
        ossz = 0;
        int o=0;
        for(Fuvar elem : Fuvar){
            if(elem.rendszam == "ABC-123"){
                ossz += elem.osszeg;
                o++;
            }
        }
        System.out.println("Átlag bevétele az ABC-123 rendszámmal rendelkező fuvarosnak: "+ossz/o);
        //3.Kinél volt a leghosszabb fuvar
        int i = 1;
        int leg_ = Fuvar[0].perc;
        int melyik = 1;
        while(i<Fuvar.length){
            if(Fuvar[i].perc > leg_){
                leg_ = Fuvar[i].perc;
                melyik = i+1;
            }
            i++;
        }
        System.out.println("A(z) "+melyik+". fuvar volt a leghosszabb.");
        //4.Hogyan fizették ki a legdrágább utat
        i = 1;
        leg_ = Fuvar[0].osszeg;
        melyik = 0;
        while(i<Fuvar.length){
            if(Fuvar[i].osszeg > leg_){
                leg_ = Fuvar[i].osszeg;
                melyik = i;
            }
            i++;
        }
        System.out.println("A legdrágább fuvar fizetési módja: "+Fuvar[melyik].fizMod);
        //5.Minden fuvar kp-s volt-e
        i=0;
        boolean fiz;
        while(i<Fuvar.length && Fuvar[i].fizMod =="kp"){
            i++;
        }
        fiz = i<Fuvar.length;
        System.out.println(fiz?"Nem minden kifizetés történt kp-ban":"Minden fizetés kp-ban történt");
        //6.Volt kártyás fizetés-e
        i=0;
        while(i<Fuvar.length && !(Fuvar[i].fizMod =="kártya")){
            i++;
        }
        fiz = i<Fuvar.length;
        System.out.println(fiz?"Történt kártyás fizetés":"Nem történt kártyás fizetés");
    }
}
