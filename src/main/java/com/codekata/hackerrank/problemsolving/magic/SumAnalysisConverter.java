package com.codekata.hackerrank.problemsolving.magic;

import java.util.ArrayList;
import java.util.List;

public class SumAnalysisConverter {

    public static SumAnalysisModel convert(MatrixSection section, int i, int sum) {
        SumAnalysisModel analysisModel = new SumAnalysisModel();
        analysisModel.setMatrixSection(section);
        analysisModel.setOrder(i);
        analysisModel.setSum(sum);
        List<String> coordinateList = new ArrayList<>();
        switch (section) {
            case COLUMN:
                if (i == 0) {
                    coordinateList.add("0,0");
                    coordinateList.add("0,1");
                    coordinateList.add("0,2");
                } else if (i == 1) {
                    coordinateList.add("1,0");
                    coordinateList.add("1,1");
                    coordinateList.add("1,2");
                } else {
                    coordinateList.add("2,0");
                    coordinateList.add("2,1");
                    coordinateList.add("2,2");
                }
                break;
            case ROW:
                if (i == 0) {
                    coordinateList.add("0,0");
                    coordinateList.add("1,0");
                    coordinateList.add("2,0");
                } else if (i == 1) {
                    coordinateList.add("0,1");
                    coordinateList.add("1,1");
                    coordinateList.add("2,1");
                } else {
                    coordinateList.add("0,2");
                    coordinateList.add("1,2");
                    coordinateList.add("2,0");
                }
                break;
            case DIAGONAL:
                if (i == 0) {
                    coordinateList.add("0,0");
                    coordinateList.add("1,1");
                    coordinateList.add("2,2");
                } else {
                    coordinateList.add("0,2");
                    coordinateList.add("1,1");
                    coordinateList.add("2,0");
                }
                break;
        }
        analysisModel.setCoordinateList(coordinateList);

        return analysisModel;
    }

}
