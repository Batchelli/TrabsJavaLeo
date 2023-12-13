public class Paralelepipedo {
    double compParalelepipedo;
    double larParalelepipedo;
    double altParalelepipedo;
    Paralelepipedo(){
        this.compParalelepipedo = compParalelepipedo;
        this.larParalelepipedo = larParalelepipedo;
        this.altParalelepipedo = altParalelepipedo;
    }
    double areaParalelepipedo(){return 2 * ((compParalelepipedo * larParalelepipedo) + (compParalelepipedo * altParalelepipedo) + (larParalelepipedo * altParalelepipedo));}
    double volParalelepipedo(){return compParalelepipedo * larParalelepipedo * altParalelepipedo;}
}
