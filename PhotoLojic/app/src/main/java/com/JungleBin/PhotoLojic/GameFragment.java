package com.JungleBin.PhotoLojic;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Vibrator;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class GameFragment extends Fragment {

    Button[][] button;
    TextView[] rowLabel;
    TextView[] colLabel;

    int[][] corMatrix = {{0,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,1,1,1,1,0,0},
            {0,1,0,0,0,0,0,0,1,0},
            {1,1,1,1,1,1,1,1,1,1},
            {0,1,0,1,0,0,1,0,1,0},
            {0,1,0,1,0,0,1,0,1,0},
            {0,1,0,1,0,0,1,0,1,0},
            {0,1,0,1,0,0,1,0,1,0},
            {0,1,1,1,1,1,1,1,1,0},
            {0,1,0,1,0,0,1,0,1,0}};
    int[][] corRow;
    int[][] corCol;

    int[][] nowMatrix;
    int[][] nowRow;
    int[][] nowCol;
    int[] rowColor;
    int[] colColor;

    int size = 10;

    int start = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        setRetainInstance(true);
        final ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_game, container, false);
        button = new Button[size][size];
        rowLabel = new TextView[size];
        colLabel = new TextView[size];
        corRow = new int[size][size / 2];
        corCol = new int[size][size / 2];
        nowMatrix = new int[size][size];
        nowRow = new int[size][size / 2];
        nowCol = new int[size][size / 2];
        rowColor = new int[size];
        colColor = new int[size];

        button[0][0] = (Button) rootView.findViewById(R.id.cell0n0);
        button[0][1] = (Button) rootView.findViewById(R.id.cell0n1);
        button[0][2] = (Button) rootView.findViewById(R.id.cell0n2);
        button[0][3] = (Button) rootView.findViewById(R.id.cell0n3);
        button[0][4] = (Button) rootView.findViewById(R.id.cell0n4);
        button[0][5] = (Button) rootView.findViewById(R.id.cell0n5);
        button[0][6] = (Button) rootView.findViewById(R.id.cell0n6);
        button[0][7] = (Button) rootView.findViewById(R.id.cell0n7);
        button[0][8] = (Button) rootView.findViewById(R.id.cell0n8);
        button[0][9] = (Button) rootView.findViewById(R.id.cell0n9);
        button[1][0] = (Button) rootView.findViewById(R.id.cell1n0);
        button[1][1] = (Button) rootView.findViewById(R.id.cell1n1);
        button[1][2] = (Button) rootView.findViewById(R.id.cell1n2);
        button[1][3] = (Button) rootView.findViewById(R.id.cell1n3);
        button[1][4] = (Button) rootView.findViewById(R.id.cell1n4);
        button[1][5] = (Button) rootView.findViewById(R.id.cell1n5);
        button[1][6] = (Button) rootView.findViewById(R.id.cell1n6);
        button[1][7] = (Button) rootView.findViewById(R.id.cell1n7);
        button[1][8] = (Button) rootView.findViewById(R.id.cell1n8);
        button[1][9] = (Button) rootView.findViewById(R.id.cell1n9);
        button[2][0] = (Button) rootView.findViewById(R.id.cell2n0);
        button[2][1] = (Button) rootView.findViewById(R.id.cell2n1);
        button[2][2] = (Button) rootView.findViewById(R.id.cell2n2);
        button[2][3] = (Button) rootView.findViewById(R.id.cell2n3);
        button[2][4] = (Button) rootView.findViewById(R.id.cell2n4);
        button[2][5] = (Button) rootView.findViewById(R.id.cell2n5);
        button[2][6] = (Button) rootView.findViewById(R.id.cell2n6);
        button[2][7] = (Button) rootView.findViewById(R.id.cell2n7);
        button[2][8] = (Button) rootView.findViewById(R.id.cell2n8);
        button[2][9] = (Button) rootView.findViewById(R.id.cell2n9);
        button[3][0] = (Button) rootView.findViewById(R.id.cell3n0);
        button[3][1] = (Button) rootView.findViewById(R.id.cell3n1);
        button[3][2] = (Button) rootView.findViewById(R.id.cell3n2);
        button[3][3] = (Button) rootView.findViewById(R.id.cell3n3);
        button[3][4] = (Button) rootView.findViewById(R.id.cell3n4);
        button[3][5] = (Button) rootView.findViewById(R.id.cell3n5);
        button[3][6] = (Button) rootView.findViewById(R.id.cell3n6);
        button[3][7] = (Button) rootView.findViewById(R.id.cell3n7);
        button[3][8] = (Button) rootView.findViewById(R.id.cell3n8);
        button[3][9] = (Button) rootView.findViewById(R.id.cell3n9);
        button[4][0] = (Button) rootView.findViewById(R.id.cell4n0);
        button[4][1] = (Button) rootView.findViewById(R.id.cell4n1);
        button[4][2] = (Button) rootView.findViewById(R.id.cell4n2);
        button[4][3] = (Button) rootView.findViewById(R.id.cell4n3);
        button[4][4] = (Button) rootView.findViewById(R.id.cell4n4);
        button[4][5] = (Button) rootView.findViewById(R.id.cell4n5);
        button[4][6] = (Button) rootView.findViewById(R.id.cell4n6);
        button[4][7] = (Button) rootView.findViewById(R.id.cell4n7);
        button[4][8] = (Button) rootView.findViewById(R.id.cell4n8);
        button[4][9] = (Button) rootView.findViewById(R.id.cell4n9);
        button[5][0] = (Button) rootView.findViewById(R.id.cell5n0);
        button[5][1] = (Button) rootView.findViewById(R.id.cell5n1);
        button[5][2] = (Button) rootView.findViewById(R.id.cell5n2);
        button[5][3] = (Button) rootView.findViewById(R.id.cell5n3);
        button[5][4] = (Button) rootView.findViewById(R.id.cell5n4);
        button[5][5] = (Button) rootView.findViewById(R.id.cell5n5);
        button[5][6] = (Button) rootView.findViewById(R.id.cell5n6);
        button[5][7] = (Button) rootView.findViewById(R.id.cell5n7);
        button[5][8] = (Button) rootView.findViewById(R.id.cell5n8);
        button[5][9] = (Button) rootView.findViewById(R.id.cell5n9);
        button[6][0] = (Button) rootView.findViewById(R.id.cell6n0);
        button[6][1] = (Button) rootView.findViewById(R.id.cell6n1);
        button[6][2] = (Button) rootView.findViewById(R.id.cell6n2);
        button[6][3] = (Button) rootView.findViewById(R.id.cell6n3);
        button[6][4] = (Button) rootView.findViewById(R.id.cell6n4);
        button[6][5] = (Button) rootView.findViewById(R.id.cell6n5);
        button[6][6] = (Button) rootView.findViewById(R.id.cell6n6);
        button[6][7] = (Button) rootView.findViewById(R.id.cell6n7);
        button[6][8] = (Button) rootView.findViewById(R.id.cell6n8);
        button[6][9] = (Button) rootView.findViewById(R.id.cell6n9);
        button[7][0] = (Button) rootView.findViewById(R.id.cell7n0);
        button[7][1] = (Button) rootView.findViewById(R.id.cell7n1);
        button[7][2] = (Button) rootView.findViewById(R.id.cell7n2);
        button[7][3] = (Button) rootView.findViewById(R.id.cell7n3);
        button[7][4] = (Button) rootView.findViewById(R.id.cell7n4);
        button[7][5] = (Button) rootView.findViewById(R.id.cell7n5);
        button[7][6] = (Button) rootView.findViewById(R.id.cell7n6);
        button[7][7] = (Button) rootView.findViewById(R.id.cell7n7);
        button[7][8] = (Button) rootView.findViewById(R.id.cell7n8);
        button[7][9] = (Button) rootView.findViewById(R.id.cell7n9);
        button[8][0] = (Button) rootView.findViewById(R.id.cell8n0);
        button[8][1] = (Button) rootView.findViewById(R.id.cell8n1);
        button[8][2] = (Button) rootView.findViewById(R.id.cell8n2);
        button[8][3] = (Button) rootView.findViewById(R.id.cell8n3);
        button[8][4] = (Button) rootView.findViewById(R.id.cell8n4);
        button[8][5] = (Button) rootView.findViewById(R.id.cell8n5);
        button[8][6] = (Button) rootView.findViewById(R.id.cell8n6);
        button[8][7] = (Button) rootView.findViewById(R.id.cell8n7);
        button[8][8] = (Button) rootView.findViewById(R.id.cell8n8);
        button[8][9] = (Button) rootView.findViewById(R.id.cell8n9);
        button[9][0] = (Button) rootView.findViewById(R.id.cell9n0);
        button[9][1] = (Button) rootView.findViewById(R.id.cell9n1);
        button[9][2] = (Button) rootView.findViewById(R.id.cell9n2);
        button[9][3] = (Button) rootView.findViewById(R.id.cell9n3);
        button[9][4] = (Button) rootView.findViewById(R.id.cell9n4);
        button[9][5] = (Button) rootView.findViewById(R.id.cell9n5);
        button[9][6] = (Button) rootView.findViewById(R.id.cell9n6);
        button[9][7] = (Button) rootView.findViewById(R.id.cell9n7);
        button[9][8] = (Button) rootView.findViewById(R.id.cell9n8);
        button[9][9] = (Button) rootView.findViewById(R.id.cell9n9);

        rowLabel[0] = (TextView) rootView.findViewById(R.id.row0);
        rowLabel[1] = (TextView) rootView.findViewById(R.id.row1);
        rowLabel[2] = (TextView) rootView.findViewById(R.id.row2);
        rowLabel[3] = (TextView) rootView.findViewById(R.id.row3);
        rowLabel[4] = (TextView) rootView.findViewById(R.id.row4);
        rowLabel[5] = (TextView) rootView.findViewById(R.id.row5);
        rowLabel[6] = (TextView) rootView.findViewById(R.id.row6);
        rowLabel[7] = (TextView) rootView.findViewById(R.id.row7);
        rowLabel[8] = (TextView) rootView.findViewById(R.id.row8);
        rowLabel[9] = (TextView) rootView.findViewById(R.id.row9);

        colLabel[0] = (TextView) rootView.findViewById(R.id.col0);
        colLabel[1] = (TextView) rootView.findViewById(R.id.col1);
        colLabel[2] = (TextView) rootView.findViewById(R.id.col2);
        colLabel[3] = (TextView) rootView.findViewById(R.id.col3);
        colLabel[4] = (TextView) rootView.findViewById(R.id.col4);
        colLabel[5] = (TextView) rootView.findViewById(R.id.col5);
        colLabel[6] = (TextView) rootView.findViewById(R.id.col6);
        colLabel[7] = (TextView) rootView.findViewById(R.id.col7);
        colLabel[8] = (TextView) rootView.findViewById(R.id.col8);
        colLabel[9] = (TextView) rootView.findViewById(R.id.col9);


        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        Uri uri = getArguments().getParcelable("imageUri");
        try {
            Bitmap bm = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), uri);
            corMatrix = mosiac(edgedetect(bm));
        } catch (Exception e) {
        }
        for (int i = 0; i < size; i++) {
            int bunch = 0;
            int k = 0;
            for (int j = 0; j < size; j++) {
                if (corMatrix[i][j] == 1) {
                    bunch += 1;
                    if (j != size - 1) {
                        if (corMatrix[i][j + 1] == 0) {
                            corRow[i][k] = bunch;
                            k += 1;
                            bunch = 0;
                        }
                    } else if (corMatrix[i][j] == 1) {
                        corRow[i][k] = bunch;
                        k += 1;
                        bunch = 0;
                    }
                }
            }
        }
        for (int j = 0; j < size; j++) {
            int bunch = 0;
            int k = 0;
            for (int i = 0; i < size; i++) {
                if (corMatrix[i][j] == 1) {
                    bunch += 1;
                    if (i != size - 1) {
                        if (corMatrix[i + 1][j] == 0) {
                            corCol[j][k] = bunch;
                            k += 1;
                            bunch = 0;
                        }
                    } else if (corMatrix[i][j] == 1) {
                        corCol[j][k] = bunch;
                        k += 1;
                        bunch = 0;
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                if (corRow[i][j] != nowRow[i][j]) {
                    rowLabel[i].setBackgroundColor(0xFFff007f);
                    rowColor[i] = 0;
                    break;
                }
                rowLabel[i].setBackgroundColor(0xFF00d8ff);
                rowColor[i] = 1;
            }

            for (int j = 0; j < size / 2; j++) {
                if (corCol[i][j] != nowCol[i][j]) {
                    colLabel[i].setBackgroundColor(0xffff007f);
                    colColor[i] = 0;
                    break;
                }
                colLabel[i].setBackgroundColor(0xff00d8ff);
                colColor[i] = 1;
            }
        }

        for (int i = 0; i < size; i++) {
            String rowText = "";
            for (int j = 0; j < size / 2; j++) {
                if (corRow[i][j] == 0) {
                    break;
                }
                rowText += corRow[i][j] + " ";
            }
            if (rowText.length() > 1) {
                rowLabel[i].setText(rowText.substring(0, rowText.length() - 1));
            }
            String colText = "";
            for (int j = 0; j < size / 2; j++) {
                if (corCol[i][j] == 0) {
                    break;
                }
                colText += corCol[i][j] + "\n";
            }
            if (colText.length() > 1) {
                colLabel[i].setText(colText.substring(0, colText.length() - 1));
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final int i_f = i;
                final int j_f = j;
                button[i_f][j_f].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(start == 0){

                        }
                        if (nowMatrix[i_f][j_f] == 0) {
                            button[i_f][j_f].setBackgroundColor(Color.BLACK);
                            nowMatrix[i_f][j_f] = 1;
                        } else {
                            button[i_f][j_f].setBackgroundColor(Color.WHITE);
                            nowMatrix[i_f][j_f] = 0;
                        }
                        for (int i1 = 0; i1 < size; i1++) {
                            int bunch = 0;
                            int k = 0;
                            for (int j1 = 0; j1 < size; j1++) {
                                if (nowMatrix[i1][j1] == 1) {
                                    bunch += 1;
                                    if (j1 != size - 1) {
                                        if (nowMatrix[i1][j1 + 1] == 0) {
                                            nowRow[i1][k] = bunch;
                                            k += 1;
                                            bunch = 0;
                                        }
                                    } else if (nowMatrix[i1][j1] == 1) {
                                        nowRow[i1][k] = bunch;
                                        k += 1;
                                        bunch = 0;
                                    }
                                }
                            }
                            while (k < size / 2) {
                                nowRow[i1][k] = 0;
                                k++;
                            }
                        }
                        for (int j1 = 0; j1 < size; j1++) {
                            int bunch = 0;
                            int k = 0;
                            for (int i1 = 0; i1 < size; i1++) {
                                if (nowMatrix[i1][j1] == 1) {
                                    bunch += 1;
                                    if (i1 != size - 1) {
                                        if (nowMatrix[i1 + 1][j1] == 0) {
                                            nowCol[j1][k] = bunch;
                                            k += 1;
                                            bunch = 0;
                                        }
                                    } else if (nowMatrix[i1][j1] == 1) {
                                        nowCol[j1][k] = bunch;
                                        k += 1;
                                        bunch = 0;
                                    }
                                }
                            }
                            while (k < size / 2) {
                                nowCol[j1][k] = 0;
                                k++;
                            }
                        }
                        for (int i1 = 0; i1 < size; i1++) {
                            for (int j1 = 0; j1 < size / 2; j1++) {
                                if (corRow[i1][j1] != nowRow[i1][j1]) {
                                    rowLabel[i1].setBackgroundColor(0xffff007f);
                                    rowColor[i1] = 0;
                                    break;
                                }
                                rowLabel[i1].setBackgroundColor(0xff00d8ff);
                                rowColor[i1] = 1;
                            }

                            for (int j1 = 0; j1 < size / 2; j1++) {
                                if (corCol[i1][j1] != nowCol[i1][j1]) {
                                    colLabel[i1].setBackgroundColor(0xffff007f);
                                    colColor[i1] = 0;
                                    break;
                                }
                                colLabel[i1].setBackgroundColor(0xff00d8ff);
                                colColor[i1] = 1;
                            }
                        }
                        int sum = 0;
                        for (int i1 = 0; i1 < size; i1++) {
                            sum += rowColor[i1];
                            sum += colColor[i1];
                        }
                        if (sum == 20) {
                            Toast.makeText(getContext(), "complete", Toast.LENGTH_LONG).show();
                            MediaPlayer player = MediaPlayer.create(getContext(), R.raw.pong);
                            player.start();
                            Vibrator vib = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                            vib.vibrate(500);

                            ((GameViewActivity) getActivity()).completeWork();
                        }
                        Vibrator vib = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                        vib.vibrate(10);
                    }
                });
            }
        }
    }


    public static Bitmap edgedetect(Bitmap src){
        int h = src.getHeight();
        int w = src.getWidth();
        int gray;
        int suma=0;
        int sumb=0;
        int value;
        int Gx[][] = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
        int Gy[][] = {{-1, -2, -1}, {0, 0, 0}, {1, 2, 1}};
        int[] array = new int[h * w];
        for (int i = 1; i < h-1; i++) {
            for (int j = 1; j < w-1; j++) {
                suma = 0;
                sumb = 0;
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        gray = getgray(src.getPixel(j-1+b, i-1+a));
                        suma += gray * Gx[a][b];
                        sumb += gray * Gy[a][b];
                    }
                }
                value = (suma > 0 ? suma : -suma) + (sumb > 0 ? sumb : -sumb);
                array[(i * w) + j] = 0xff000000 | (value << 16) | (value << 8) | value;
            }
        }
        Bitmap sobelbit = Bitmap.createBitmap(array,w,h, Bitmap.Config.ARGB_8888);
        return sobelbit;
    }
    public static int getgray(int a) {
        return ((a>>16 &0xff)+(a>>8&0xff)+(a&0xff))/3;
    }

    public static int[][] mosiac(Bitmap src){

        double[][] dbout = new double[10][10];
        double sumdb = 0;
        double avgdb = 0;
        double maxA, maxR, maxG, maxB;
        int pixel;

        int width = src.getWidth()/10;
        int height = src.getHeight()/10;

        int[][] intout = new int[10][10];

        for(int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++){
                maxR=0;
                maxG=0;
                maxB=0;
                for(int i=0; i<width;i++){
                    for( int j=0;j<height;j++){
                        pixel = src.getPixel(x*width+i,y*height+j);
                        maxR += Color.red(pixel);
                        maxG += Color.green(pixel);
                        maxB += Color.blue(pixel);
                    }
                }
                dbout[x][y] = (maxR + maxG + maxB)/(3 * width * height);
                sumdb += dbout[x][y];
            }
        }
        avgdb = sumdb/100;
        for(int x = 0; x < 10; x++){
            for (int y = 0; y < 10; y++) {
                if(dbout[y][x]>=(avgdb)){
                    intout[x][y] = 1;
                }
                else{
                    intout[x][y] = 0;
                }
            }
        }

        return intout;
    }
}
