char** findRelativeRanks(int* score, int scoreSize, int* returnSize) {
    char** result=(char**)malloc(sizeof(char*)*scoreSize);
    int* sorted=(int*)malloc(sizeof(int)*scoreSize);
    for (int i=0;i<scoreSize;i++){
        sorted[i]=score[i];
    }
    for (int i=0;i<scoreSize-1;i++){
        for (int j=i+1;j<scoreSize;j++){
            if (sorted[i]<sorted[j]){
                int temp=sorted[i];
                sorted[i]=sorted[j];
                sorted[j]=temp;
            }
        }
    }

    for (int i=0;i<scoreSize;i++){
        int rank=0;
        for (int j=0;j<scoreSize;j++){
            if (score[i]==sorted[j]){
                rank=j+1;
                break;
            }
        }
        result[i]=(char*)malloc(20);
        if (rank==1){
            sprintf(result[i], "Gold Medal");
        } else if (rank==2){
            sprintf(result[i], "Silver Medal");
        } else if (rank==3){
            sprintf(result[i], "Bronze Medal");
        } else {
            sprintf(result[i], "%d", rank);
        }
    }

    *returnSize=scoreSize;
    free(sorted);
    return result;
}
