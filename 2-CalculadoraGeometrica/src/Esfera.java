public class Esfera {
    double raioEsfera;
    Esfera(){this.raioEsfera = raioEsfera;}
    double areaEsfera(){return 4 * Math.PI * Math.pow(raioEsfera, 2);}
    double volEsfera(){return (4 / 3.0) * Math.PI * Math.pow(raioEsfera, 3);}
}
