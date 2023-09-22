import org.w3c.dom.ls.LSOutput;

public class Frequency {
    private final String bandName;
    private float hz;
    private float hzPrecision;
    private float width;
    private float widthPrecision;
    private float voltage;
    private float voltagePrecision;
    private boolean enable;

    private int minFreqRange;
    private int maxFreqRange;

    /*
    COLORED TEXT
     */
    private String GREEN = "\u001B[32m";
    private String RED = "\u001B[31m";
    private String RESET = "\u001B[0m";
    private String WHITE_BG = "\u001B[47m";


    // GETTERS FOR ALL INFOS
    public void getInfo(){
        if (enable){
            System.out.println(bandName + " range infos :\n------------------");
            System.out.println(hz + " Hz");
            System.out.println(voltage + " V");
            System.out.println(width + " Octaves\n");
        }
        else
            System.out.println("------------------\n" + bandName + " range disabled\n------------------\n");
    }

    public int getMinFreqRange() {
        return minFreqRange;
    }

    public int getMaxFreqRange() {
        return maxFreqRange;
    }

    public float getHz() {
        return hz;
    }

    // SETTERS
    public void setEnable(boolean enable) {
        this.enable = enable;
    }
    public void setHz(float hz) {
        this.hz = hz;
    }
    public void setWidth(float width) {
        this.width = width;
    }
    public void setVoltage(float voltage) {
        this.voltage = voltage;
    }

    public void setHzPrecision(float hzPrecision) {
        this.hzPrecision = hzPrecision;
    }

    public void setWidthPrecision(float widthPrecision) {
        this.widthPrecision = widthPrecision;
    }

    public void setVoltagePrecision(float voltagePrecision) {
        this.voltagePrecision = voltagePrecision;
    }



    // PREDEFINED VALUES MANAGER
    public void lessHz(){
        System.out.println(RED + this.bandName + " - " + this.hzPrecision + " hz\n" + RESET) ;
        this.hz -= hzPrecision;
    }
    public void lessWidth(){
        System.out.println(RED + this.bandName + " - " + this.widthPrecision + " Octaves\n" + RESET);
        this.width -= widthPrecision;
    }
    public void lessVoltage(){
        System.out.println(RED + this.bandName + " - " + this.voltagePrecision + " V\n" + RESET);
        this.voltage -= voltagePrecision;
    }
    public void moreHz(){
        System.out.println(GREEN + this.bandName + " + " + this.hzPrecision + " hz\n" + RESET);
        this.hz += hzPrecision;
    }
    public void moreWidth(){
        System.out.println(GREEN + this.bandName + " + " + this.widthPrecision + " Octaves\n" + RESET);
        this.width += widthPrecision;
    }
    public void moreVoltage(){
        System.out.println(GREEN + this.bandName + " + " + this.voltagePrecision + " V\n" + RESET);
        this.voltage += voltagePrecision;
    }


// CONSTRUCTOR
    public Frequency(String bandName, float hz, float voltage, int minFreqRange, int maxFreqRange) {
        this.bandName = bandName;
        this.enable = true;
        this.hz = hz;
        this.hzPrecision = 50;
        this.voltage = voltage;
        this.voltagePrecision = 3;
        this.width = 1.4f;
        this.widthPrecision = 0.4f;
        this.minFreqRange = minFreqRange;
        this.maxFreqRange = maxFreqRange;
    }
}
