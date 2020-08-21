package com.example.tpn1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculadora extends AppCompatActivity {

    Button btnNumber0;
    Button btnNumber1;
    Button btnNumber2;
    Button btnNumber3;
    Button btnNumber4;
    Button btnNumber5;
    Button btnNumber6;
    Button btnNumber7;
    Button btnNumber8;
    Button btnNumber9;
    TextView txtResult;
    EditText edtInput;
    Button btnC;
    Button btnAdd;
    Button btnSub;
    Button btnMul;
    Button btnDiv;
    Button btnResult;
    double val1 = Double.NaN;
    double val2;
    String ACTION = null;
    private Boolean wasResultBtnPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        btnNumber0 = (Button) findViewById(R.id.btnNumber0);
        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);
        txtResult = (TextView) findViewById(R.id.txtResult);
        edtInput = (EditText) findViewById(R.id.edtInput);
        btnC = (Button) findViewById(R.id.btnC);
        btnAdd = (Button) findViewById(R.id.btnNumberAdd);
        btnSub = (Button) findViewById(R.id.btnNumberSub);
        btnMul = (Button) findViewById(R.id.btnNumberMul);
        btnDiv = (Button) findViewById(R.id.btnNumberDiv);
        btnResult = (Button) findViewById(R.id.btnResult);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                val1 = Double.NaN;
                txtResult.setText(null);
                edtInput.setText(null);
                btnAdd.setEnabled(true);
                btnSub.setEnabled(true);
                btnMul.setEnabled(true);
                btnDiv.setEnabled(true);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "+";

                try {
                    if (!Double.isNaN(val1)) {
                        val2 = Double.parseDouble(edtInput.getText().toString());
                        val1 += val2;
                    } else {
                        val1 = Double.parseDouble(edtInput.getText().toString());
                    }

                    txtResult.setText(String.format("%s + ", val1));
                    edtInput.setText(null);
                    btnAdd.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMul.setEnabled(false);
                    btnDiv.setEnabled(false);
                } catch (Exception ignored) {}
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "-";

                try {
                    if (!Double.isNaN(val1)) {
                        val2 = Double.parseDouble(edtInput.getText().toString());
                        val1 -= val2;
                    } else {
                        val1 = Double.parseDouble(edtInput.getText().toString());
                    }

                    txtResult.setText(String.format("%s - ", val1));
                    edtInput.setText(null);
                    btnAdd.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMul.setEnabled(false);
                    btnDiv.setEnabled(false);
                } catch (Exception ignored) {}
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "*";

                try {
                    if (!Double.isNaN(val1)) {
                        val2 = Double.parseDouble(edtInput.getText().toString());
                        val1 *= val2;
                    } else {
                        val1 = Double.parseDouble(edtInput.getText().toString());
                    }

                    txtResult.setText(String.format("%s * ", val1));
                    edtInput.setText(null);
                    btnAdd.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMul.setEnabled(false);
                    btnDiv.setEnabled(false);
                } catch (Exception ignored) {}
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ACTION = "/";

                try {
                    if (!Double.isNaN(val1)) {
                        val2 = Double.parseDouble(edtInput.getText().toString());
                        if (val2 == 0) {
                            val1 = 0;
                        } else {
                            val1 /= val2;
                        }
                    } else {
                        val1 = Double.parseDouble(edtInput.getText().toString());
                    }

                    txtResult.setText(String.format("%s / ", val1));
                    edtInput.setText(null);
                    btnAdd.setEnabled(false);
                    btnSub.setEnabled(false);
                    btnMul.setEnabled(false);
                    btnDiv.setEnabled(false);
                } catch (Exception ignored) {}
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (Double.isNaN(val1)) {
                        return;
                    }

                    double val2 = Double.parseDouble(edtInput.getText().toString());

                    if (ACTION != null && ACTION.equals("+")){
                        val1 += val2;
                    } else if (ACTION != null && ACTION.equals("-")){
                        val1 -= val2;
                    } else if (ACTION != null && ACTION.equals("*")){
                        val1 *= val2;
                    } else if (ACTION != null && ACTION.equals("/")) {
                        if (val2 == 0) {
                            val1 = 0;
                        } else {
                            val1 /= val2;
                        }
                    }

                    txtResult.setText(null);
                    edtInput.setText(String.valueOf(val1));

                    val1 = Double.NaN;
                    edtInput.setSelection(edtInput.getText().length());
                    wasResultBtnPressed = true;
                    btnAdd.setEnabled(true);
                    btnSub.setEnabled(true);
                    btnMul.setEnabled(true);
                    btnDiv.setEnabled(true);
                } catch (Exception ignored) {}
            }
        });

        btnNumber0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s0", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s1", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s2", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s3", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s4", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s5", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s6", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s7", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s8", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });

        btnNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (wasResultBtnPressed) {
                    wasResultBtnPressed = false;
                    edtInput.setText(null);
                }

                edtInput.setText(String.format("%s9", edtInput.getText()));
                edtInput.setSelection(edtInput.getText().length());
            }
        });
    }
}