import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Equalizer extends JFrame{
    private JSlider freqSliderLow;
    private JSlider freqSliderMid;
    private JSlider freqSliderHigh;
    private JCheckBox midCheckBox;
    private JCheckBox lowCheckBox;
    private JSlider vSliderHigh;
    private JSlider vSliderMid;
    private JSlider vSliderLow;
    private JSlider qSliderLow;
    private JSlider qSliderMid;
    private JPanel eqUi;
    private JSlider qSliderHigh;
    private JCheckBox highCheckBox;
    private JLabel lowValue;
    private JLabel midValue;
    private JLabel highValue;

    public static void getAllInfos(Frequency l, Frequency m, Frequency h){
        l.getInfo();
        m.getInfo();
        h.getInfo();
    }

    public Equalizer(){

        Frequency low = new Frequency("low",200, 0,0, 200);
        Frequency mid = new Frequency("mid",2500, 0, 200, 2000);
        Frequency high = new Frequency("high",12000, 0, 2000, 20000);
        getAllInfos(low, mid, high);

        low.moreVoltage();

        freqSliderLow.setMinimum(low.getMinFreqRange());
        freqSliderLow.setMaximum(low.getMaxFreqRange());
        freqSliderLow.setValue((int)low.getHz());
        lowValue.setText(String.valueOf((float)freqSliderLow.getValue()) + " hz");

        freqSliderMid.setMinimum(mid.getMinFreqRange());
        freqSliderMid.setMaximum(mid.getMaxFreqRange());
        freqSliderMid.setValue((int) mid.getHz());
        midValue.setText(String.valueOf((float)freqSliderMid.getValue()) + " hz");

        freqSliderHigh.setMinimum(high.getMinFreqRange());
        freqSliderHigh.setMaximum(high.getMaxFreqRange());
        freqSliderHigh.setValue((int) high.getHz());
        highValue.setText(String.valueOf((float)freqSliderHigh.getValue()) + " hz");

        setContentPane(eqUi);
        setTitle("JEqualizer");
        setSize(1299, 369);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        lowCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lowCheckBox.isSelected()){
                    low.setEnable(false);
                    System.out.println("Low Freq OFF");
                    low.getInfo();
                }
                else{
                    low.setEnable(true);
                    System.out.println("Low Freq ON");
                    low.getInfo();
                }

            }
        });
        midCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(midCheckBox.isSelected()){
                    mid.setEnable(false);
                    System.out.println("Mid Freq OFF");
                    mid.getInfo();
                }
                else{
                    mid.setEnable(true);
                    System.out.println("Mid Freq ON");
                    mid.getInfo();
                }
            }
        });
        highCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(highCheckBox.isSelected()){
                    high.setEnable(false);
//                    high.disabledMode(true);
                    System.out.println("High Freq OFF");
                    high.getInfo();
                }
                else{
                    high.setEnable(true);
//                    high.disabledMode(false);
                    System.out.println("High Freq ON");
                    high.getInfo();

                }
            }
        });

        freqSliderLow.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                low.setHz(freqSliderLow.getValue());
                low.getInfo();
                lowValue.setText(String.valueOf(low.getHz()) + " hz");
            }
        });
        freqSliderMid.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                mid.setHz(freqSliderMid.getValue());
                mid.getInfo();
                midValue.setText(String.valueOf(mid.getHz()) + " hz");
            }
        });
        freqSliderHigh.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                high.setHz(freqSliderHigh.getValue());
                high.getInfo();
                highValue.setText(String.valueOf(high.getHz()) + " hz");
            }
        });
    }
}
