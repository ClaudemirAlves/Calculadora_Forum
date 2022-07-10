package com.claudemirandrade.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button percent, closeParenthese, openParenthese, div, seven, eight, nine, mul, four, five, six,
        sub, one, two, three, add, zero, point, back, equals;

    TextView textView, textView2, textView3, textViewOperation, textViewParentheses;

    private String operation2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percent = (Button) findViewById(R.id.percent);
        closeParenthese = (Button) findViewById(R.id.closeParenthese);
        openParenthese = (Button) findViewById(R.id.openParenthese);
        div = (Button) findViewById(R.id.div);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        mul = (Button) findViewById(R.id.mul);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        sub = (Button) findViewById(R.id.sub);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        add = (Button) findViewById(R.id.add);
        zero = (Button) findViewById(R.id.zero);
        point = (Button) findViewById(R.id.point);
        back = (Button) findViewById(R.id.back);
        equals = (Button) findViewById(R.id.equals);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textViewOperation = (TextView) findViewById(R.id.textViewOperation);
        textViewParentheses = (TextView) findViewById(R.id.textViewParentheses);

    }

    boolean bool = false;
    boolean erroOperacional = false;

    public void percent(View v) {
        if (textView.getText().toString() != "") {
            String prevValue = textView.getText().toString();
            textView2.setText(prevValue);
            textView3.setText("");
            textView.setText("");
        }
        bool = true;
        textViewOperation.setText("%");
    }

    public void closeParenthese(View v) {
        String parenthesesContent = textViewParentheses.getText().toString();
        if (parenthesesContent != "") {
            String text2 = textView2.getText().toString();
            if (text2.equals("")) {
                text2 = "0";
            }
            String text3 = textView3.getText().toString();
            if (text3.equals("")) {
                text3 = "0";
            }
            if (text2.endsWith(".") || text3.endsWith(".")) {
                Toast.makeText(MainActivity.this, "Insira um número após o ponto", Toast.LENGTH_SHORT).show();
            } else {
                String operation = textViewOperation.getText().toString();
                String parenthesesContentFinal;
                parenthesesContentFinal = parenthesesContent.substring(0, parenthesesContent.length() - 2);
                if (!operation.equals("")) {
                    String result;
                    textView2.setText(parenthesesContentFinal);
                    float txt2 = Float.parseFloat(text2);
                    float txt3 = Float.parseFloat(text3);
                    if (operation.contains("+")) {
                        float calculation = txt2 + txt3;
                        textViewOperation.setText(operation2);
                        result = String.valueOf(calculation);
                        textView3.setText(result);
                    } else if (operation.contains("-")) {
                        float calculation = txt2 - txt3;
                        textViewOperation.setText(operation2);
                        result = String.valueOf(calculation);
                        textView3.setText(result);
                    } else if (operation.contains("x")) {
                        float calculation = txt2 * txt3;
                        textViewOperation.setText(operation2);
                        result = String.valueOf(calculation);
                        textView3.setText(result);
                    } else if (operation.contains("÷")) {
                        if (txt3 >= 0 && txt3 < 0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001) {
                            Toast.makeText(MainActivity.this, "Não é possível dividir por zero", Toast.LENGTH_SHORT).show();
                            textViewParentheses.setText("");
                            textViewOperation.setText("");
                            textView.setText("");
                            textView2.setText("");
                            textView3.setText("");
                            bool = false;
                            erroOperacional = true;
                        } else {
                            float calculation = txt2 / txt3;
                            textViewOperation.setText(operation2);
                            result = String.valueOf(calculation);
                            textView3.setText(result);
                        }
                    } else if (operation.contains("%")) {
                        float calculation = txt2 * txt3 / 100;
                        textViewOperation.setText(operation2);
                        result = String.valueOf(calculation);
                        textView3.setText(result);
                    }
                } else {
                    textView2.setText(parenthesesContentFinal);
                    textView3.setText(text2);
                    textView2.setText(parenthesesContentFinal);
                    textViewOperation.setText(operation2);
                }
                if (!erroOperacional) {
                    textViewParentheses.setText(parenthesesContent + text2 + operation + text3 + ")");
                }
                erroOperacional = false;
            }
        } else {
            Toast.makeText(MainActivity.this, "Não há parênteses aberto", Toast.LENGTH_SHORT).show();
        }
    }

    public void openParenthese(View v) {
        if (textViewOperation.getText() == "+"
                || textViewOperation.getText() == "-"
                || textViewOperation.getText() == "x"
                || textViewOperation.getText() == "÷"
                || textViewOperation.getText() == "%") {
            String str = textView2.getText().toString();
            String operation = textViewOperation.getText().toString();
            operation2 = operation;
            textView2.setText("");
            textViewOperation.setText("");
            String str_parentheses = str + operation + "(";
            textViewParentheses.setText(str_parentheses);
            bool = false;
        } else {
            Toast.makeText(MainActivity.this, "Insira uma operação antes de abrir parênteses", Toast.LENGTH_SHORT).show();
        }
    }

    public void div(View v) {
        if (textView.getText().toString() != "") {
            String prevValue = textView.getText().toString();
            textView2.setText(prevValue);
            textView3.setText("");
            textView.setText("");
        }
        bool = true;
        textViewOperation.setText("÷");
    }

    public void seven(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            textView2.setText(str + "7");
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "7");
        }
    }

    public void eight(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            textView2.setText(str + "8");
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "8");
        }
    }

    public void nine(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            textView2.setText(str + "9");
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "9");
        }
    }

    public void mul(View v) {
        if (textView.getText().toString() != "") {
            String prevValue = textView.getText().toString();
            textView2.setText(prevValue);
            textView3.setText("");
            textView.setText("");
        }
        bool = true;
        textViewOperation.setText("x");
    }

    public void four(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            textView2.setText(str + "4");
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "4");
        }
    }

    public void five(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            textView2.setText(str + "5");
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "5");
        }
    }

    public void six(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            textView2.setText(str + "6");
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "6");
        }
    }

    public void sub(View v) {
        if (textView.getText().toString() != "") {
            String prevValue = textView.getText().toString();
            textView2.setText(prevValue);
            textView3.setText("");
            textView.setText("");
        }
        bool = true;
        textViewOperation.setText("-");
    }

    public void one(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            textView2.setText(str + "1");
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "1");
        }
    }

    public void two(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            textView2.setText(str + "2");
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "2");
        }
    }

    public void three(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            textView2.setText(str + "3");
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "3");
        }
    }

    public void add(View v) {
        if (textView.getText().toString() != "") {
            String prevValue = textView.getText().toString();
            textView2.setText(prevValue);
            textView3.setText("");
            textView.setText("");
        }
        bool = true;
        textViewOperation.setText("+");
    }

    public void zero(View v) {
        if (textView.getText().toString() != "") {
            textView.setText("");
            textView2.setText("");
            textView3.setText("");
            textViewOperation.setText("");
        }
        textView.setText("");
        if (bool == false) {
            String str = textView2.getText().toString();
            if (str.length() > 0) {
                textView2.setText(str + "0");
            } else {
                textView2.setText(str);
            }
        } else {
            String str = textView3.getText().toString();
            textView3.setText(str + "0");
        }
    }

    public void point(View v) {
        if (bool == false) {
            String str_point = textView2.getText().toString();
            if (str_point.contains(".")) {
                Toast.makeText(MainActivity.this, "Número já é decimal", Toast.LENGTH_SHORT).show();
            } else {
                String str = textView2.getText().toString();
                textView2.setText(str + ".");
            }
        } else {
            String str_point = textView3.getText().toString();
            if (str_point.contains(".")) {
                Toast.makeText(MainActivity.this, "Número já é decimal", Toast.LENGTH_SHORT).show();
            } else {
                String str = textView3.getText().toString();
                textView3.setText(str + ".");
            }
        }
    }

    public void back(View v) {
        if (bool == false) {
            String str = textView2.getText().toString();
            if (str.length() > 0) {
                String str_back = str.substring(0, str.length() -1);
                textView2.setText(str_back);
            } else {
                textView2.setText("");
                textViewParentheses.setText("");
            }
        } else {
            String str = textView3.getText().toString();
            if (str.length() > 0) {
                String str_back = str.substring(0, str.length() -1);
                textView3.setText(str_back);
            } else {
                textViewOperation.setText("");
                bool = false;
            }
        }
        if (textView2.getText().toString().equals("")) {
            bool = true;
        }
        if (textView2.getText().toString().equals("") && textView3.getText().toString().equals("")) {
            textView.setText("");
            textViewOperation.setText("");
            bool = false;
        }
    }

    public void equals(View v) {
        String text2 = textView2.getText().toString();
        if (text2.equals("")) {
            text2 = "0";
        }
        String text3 = textView3.getText().toString();
        if (text3.equals("")) {
            text3 = "0";
        }
        if (text2.endsWith(".") || text3.endsWith(".")) {
            Toast.makeText(MainActivity.this, "Insira um número após o ponto", Toast.LENGTH_SHORT).show();
        } else {
            String operation = textViewOperation.getText().toString();
            String result;
            if (text3.length() > 0) {
                float txt2 = Float.parseFloat(text2);
                float txt3 = Float.parseFloat(text3);
                if (operation.contains("+")) {
                    float calculation = txt2 + txt3;
                    result = String.valueOf(calculation);
                    textView.setText(result);
                } else if (operation.contains("-")) {
                    float calculation = txt2 - txt3;
                    result = String.valueOf(calculation);
                    textView.setText(result);
                } else if (operation.contains("x")) {
                    float calculation = txt2 * txt3;
                    result = String.valueOf(calculation);
                    textView.setText(result);
                } else if (operation.contains("÷")) {
                    if (txt3 >= 0 && txt3 < 0.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001) {
                        Toast.makeText(MainActivity.this, "Não é possível dividir por zero", Toast.LENGTH_SHORT).show();
                        textViewParentheses.setText("");
                        textViewOperation.setText("");
                        textView.setText("");
                        textView2.setText("");
                        textView3.setText("");
                    } else {
                        float calculation = txt2 / txt3;
                        result = String.valueOf(calculation);
                        textView.setText(result);
                    }
                } else if (operation.contains("%")) {
                    float calculation = txt2 * txt3 / 100;
                    result = String.valueOf(calculation);
                    textView.setText(result);
                }
            } else {
                textView.setText(text2);
            }
            textViewParentheses.setText("");
            bool = false;
        }
    }

}