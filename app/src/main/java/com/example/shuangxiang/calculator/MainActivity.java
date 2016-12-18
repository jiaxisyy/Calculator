package com.example.shuangxiang.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText etad;
    private EditText etda;
    private Button btngo;
    private TextView tvshow;
    private LinearLayout activitymain;
    private EditText etE08X08T;
    private EditText ettc;
    private EditText etpt;
    private EditText etE08X08R;
    private EditText etE16X;
    private EditText etE16T;
    private StringBuilder allShow;
    private int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allShow = new StringBuilder();
                boolean emptyAD = etad.getText().toString().isEmpty();
                boolean emptyDA = etda.getText().toString().isEmpty();
                boolean emptyTC = ettc.getText().toString().isEmpty();
                boolean emptyPT = etpt.getText().toString().isEmpty();
                boolean emptyE08X08T = etE08X08T.getText().toString().isEmpty();
                boolean emptyE08X08R = etE08X08R.getText().toString().isEmpty();
                boolean emptyE16X = etE16X.getText().toString().isEmpty();
                boolean emptyE16T = etE16T.getText().toString().isEmpty();
                if (emptyAD || emptyDA || emptyTC||emptyPT||emptyE08X08T||emptyE08X08R||emptyE16X||emptyE16T) {
                    Toast.makeText(MainActivity.this, "输入不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    int adNum = Integer.parseInt(etad.getText().toString());
                    int daNum = Integer.parseInt(etda.getText().toString());
                    int tcNum = Integer.parseInt(ettc.getText().toString());
                    int ptNum = Integer.parseInt(etpt.getText().toString());
                    int e08X08TNum = Integer.parseInt(etE08X08T.getText().toString());
                    int e08X08RNum = Integer.parseInt(etE08X08R.getText().toString());
                    int e16XNum = Integer.parseInt(etE16X.getText().toString());
                    int e16TNum = Integer.parseInt(etE16T.getText().toString());



                    DBManager instance = new MyApplication().instance;
                    instance.insertUser(new Statistics(count,"统计",adNum,daNum,tcNum,ptNum,e08X08TNum,e08X08RNum,e16XNum,e16TNum));
                    count++;
                    //TODO


                    if (adNum == 0 || daNum == 0) {
                        if (adNum == 0) {
                            if (daNum % 2 == 0 && daNum / 2 > 0) {
                                //能被2整除
                                if (!TextUtils.isEmpty(adZero(daNum))) {
                                    allShow.append(adZero(daNum));
                                }


                            } else {
                                //不能被2整除
                                if (!TextUtils.isEmpty(adZero(daNum + 1))) {
                                    allShow.append(adZero(daNum + 1));
                                }

                            }


                        } else if (daNum == 0) {
                            if (adNum % 2 == 0 && adNum / 2 > 0) {
                                //能被2整除
                                if (!TextUtils.isEmpty(daZero(adNum))) {
                                    allShow.append(daZero(adNum));

                                }


                            } else {
                                //不能被2整除
                                if (!TextUtils.isEmpty(daZero(adNum + 1))) {
                                    allShow.append(daZero(adNum + 1));
                                }

                            }

                        }


                    } else if (adNum == 0 && daNum == 0) {
                        return;
                    } else {
                        if (!TextUtils.isEmpty(abNumber(adNum, "AD", daNum, "DA"))) {
                            allShow.append(abNumber(adNum, "AD", daNum, "DA"));
                        }

                    }

                    //计算tc

                    if(tcNum!=0&&!TextUtils.isEmpty(resultTC(tcNum))){
                        allShow.append(resultTC(tcNum));
                    }
                    if(ptNum!=0&&!TextUtils.isEmpty(etpt.getText().toString())){
                        allShow.append(ptNum);
                        allShow.append("*PT");
                    }
                    if(e08X08TNum!=0&&!TextUtils.isEmpty(etE08X08T.getText().toString())){
                        allShow.append(e08X08TNum);
                        allShow.append("*08X08T");
                    }
                    if(e08X08RNum!=0&&!TextUtils.isEmpty(etE08X08R.getText().toString())){
                        allShow.append(e08X08RNum);
                        allShow.append("*08X08R");
                    }
                    if(e16XNum!=0&&!TextUtils.isEmpty(etE16X.getText().toString())){
                        allShow.append(e16XNum);
                        allShow.append("*16X");
                    }
                    if(e16TNum!=0&&!TextUtils.isEmpty(etE16T.getText().toString())){
                        allShow.append(e16TNum);
                        allShow.append("*16T");
                    }
                }

                tvshow.setText(allShow.toString());


            }
        });

    }



    /**
     * 计算TC
     *
     * @param tcNum
     */
    private String resultTC(int tcNum) {
        int newTCNum = 0;
        int count4 = 0;
        int count6 = 0;

        if (tcNum / 2 > 0 && tcNum % 2 == 0) {//能被2整除
            newTCNum = tcNum;

        } else {
            newTCNum = tcNum + 1;
        }

        int s6 = newTCNum / 6;
        int y6 = newTCNum % 6;
        if (s6 > 0) {//大于等于6

            count6 = s6;
            if (y6 > 0) {
                count4 = 1;
            }
            String s=count4==0?"":count4 + "*04TC"+"\n";
            return count6 + "*06TC" +"\n"+s;

        } else {//小于6

            count4 = 1;
            return count4 + "*04TC"+"\n";
        }
    }

    /**
     * ad为0
     *
     * @param daNum
     * @return
     */
    private String adZero(int daNum) {

        List<Integer> list8 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int count2 = 0;
        int count4 = 0;
        int count8 = 0;

        int s8 = daNum / 8;
        int y8 = daNum % 8;
        if (s8 > 0) {   //大于等于8
            if (y8 > 0) {
                //得出几个8
                list8.add(s8);
                //得出几个4
                int s4 = y8 / 4;
                if (s4 > 0) {
                    list4.add(s4);
                }
                //得出几个2
                int y4 = y8 % 4;
                if (y4 > 0) {
                    list2.add(1);
                }
            } else {
                list8.add(s8);
            }


        } else {    //小于8

            if (daNum == 6) {
                list4.add(1);
                list2.add(1);
            } else if (daNum == 4) {
                list4.add(1);
            } else if (daNum == 2) {
                list2.add(1);
            }


        }
        for (Integer integer : list2) {

            count2 = integer + count2;
        }
        for (Integer integer : list4) {

            count4 = integer + count4;
        }
        for (Integer integer : list8) {

            count8 = integer + count8;
        }

        StringBuffer stringBuffer = new StringBuffer();
        if (count2 != 0) {
            stringBuffer.append(count2);
            stringBuffer.append("*2DA ");
            stringBuffer.append("\n");
        }
        if (count4 != 0) {
            stringBuffer.append(count4);
            stringBuffer.append("*4DA ");
            stringBuffer.append("\n");
        }
        if (count8 != 0) {
            stringBuffer.append(count8);
            stringBuffer.append("*8DA ");
            stringBuffer.append("\n");
        }

        return stringBuffer.toString();
    }

    private String daZero(int adNum) {

        List<Integer> list8 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int count2 = 0;
        int count4 = 0;
        int count8 = 0;

        int s8 = adNum / 8;
        int y8 = adNum % 8;
        if (s8 > 0) {   //大于等于8
            if (y8 > 0) {
                //得出几个8
                list8.add(s8);
                //得出几个4
                int s4 = y8 / 4;
                if (s4 > 0) {
                    list4.add(s4);
                }
                //得出几个2
                int y4 = y8 % 4;
                if (y4 > 0) {
                    list2.add(1);
                }
            } else {
                list8.add(s8);
            }


        } else {    //小于8

            if (adNum == 6) {
                list4.add(1);
                list2.add(1);
            } else if (adNum == 4) {
                list4.add(1);
            } else if (adNum == 2) {
                list2.add(1);
            }


        }
        for (Integer integer : list2) {

            count2 = integer + count2;
        }
        for (Integer integer : list4) {

            count4 = integer + count4;
        }
        for (Integer integer : list8) {

            count8 = integer + count8;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (count2 != 0) {
            stringBuffer.append(count2);
            stringBuffer.append("*2AD");
            stringBuffer.append("\n");
        }
        if (count4 != 0) {
            stringBuffer.append(count4);
            stringBuffer.append("*4AD ");
            stringBuffer.append("\n");
        }
        if (count8 != 0) {
            stringBuffer.append(count8);
            stringBuffer.append("*8AD ");
            stringBuffer.append("\n");
        }

        return stringBuffer.toString();
    }

    private String goADDA(int adNum, int daNum) {
        String typyA = abNumber(adNum, "AD");
        String typyb = abNumber(daNum, "DA");
        return typyA + "\n" + typyb;
    }

    private String abNumber(int adNum, String type) {
        int a4Number = adNum / 4;
        int a2Number = 0;
        if (adNum % 4 <= 2) {
            if (adNum % 4 > 0)
                a2Number = 1;
        } else {
            a4Number = 1 + a4Number;
        }
        return a4Number + "4" + type + "-" + a2Number + "2" + type;
    }

    private String abNumber(int adNum, String type, int adNum1, String type1) {
        int a4Number = adNum / 4;
        int a2Number = 0;
        if (adNum % 4 <= 2) {
            if (adNum % 4 > 0)
                a2Number = 1;
        } else {
            a4Number = 1 + a4Number;
        }

        int a4Number1 = adNum1 / 4;
        int a2Number1 = 0;
        if (adNum1 % 4 <= 2) {
            if (adNum1 % 4 > 0)
                a2Number1 = 1;
        } else {
            a4Number1 = 1 + a4Number1;
        }

        if (a4Number == a4Number1) {
            if (a2Number == a2Number1) {
                return a4Number + "*" + 4 + "AD" + 4 + "DA" + "" +
                        "\n" + a2Number + "*" + 2 + "AD" +"\n" + a2Number+ "*"+2 + "DA" + "";
            } else {
                String typeString = a4Number1 + "*" + 4 + "AD" + 4 + "DA" + "\n";
                String typrString = "";
                String typaString = "";
                if (a2Number > 0)
                    typrString = 1 + "*2AD";
                if (a2Number1 > 0)
                    typaString = 1 + "*2DA";
                return typeString + typrString + typaString;
            }
        }
        if (a4Number > a4Number1) {
            String typeString = a4Number1 + "*" + 4 + "AD" + 4 + "DA" + "\n";
            String typrString = "";
            String typaString = "";
            String typbString = "";
            if (a2Number1 > 0) {
                typrString = 1 + "*" + 4 + "AD" + 2 + "DA" + "\n";
            }
            typaString = a4Number - a4Number1 - a2Number1 + "*" + 4 + "AD" + "\n";
            if (a2Number > 0)
                typbString = 2 + "*AD";
            return typeString + typrString + typaString + typbString;
        }
        if (a4Number < a4Number1) {
            String typeString = a4Number + "*" + 4 + "AD" + 4 + "DA" + "\n";
            String typrString = "";
            String typaString = "";
            String typbString = "";
            if (a2Number > 0) {
                typrString = 1 + "*" + 2 + "AD" + "\n";
            }
            if (a4Number1 - a4Number > 0)
                typaString = a4Number1 - a4Number + "*" + 4 + "DA" + "\n";

            if (a2Number1 > 0)
                typbString = 2 + "*DA";
            return typeString + typrString + typaString + typbString;
        }

        return a4Number + "4" + type + "-" + a2Number + "2" + type;
    }

    private void initialize() {

        etad = (EditText) findViewById(R.id.etad);
        etda = (EditText) findViewById(R.id.etda);
        btngo = (Button) findViewById(R.id.btn_go);
        tvshow = (TextView) findViewById(R.id.tv_show);
        activitymain = (LinearLayout) findViewById(R.id.activity_main);
        etE08X08T = (EditText) findViewById(R.id.etE08X08T);
        ettc = (EditText) findViewById(R.id.ettc);
        etpt = (EditText) findViewById(R.id.etpt);
        etE08X08R = (EditText) findViewById(R.id.etE08X08R);
        etE16X = (EditText) findViewById(R.id.etE16X);
        etE16T = (EditText) findViewById(R.id.etE16T);
    }


}
