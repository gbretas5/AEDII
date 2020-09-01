#include "mergesort.h"
#include <stdlib.h>
//=============================================================================
void mergesort(int *array, int n) {
   mergesortRec(array, 0, n-1);
}
//=============================================================================
void mergesortRec(int *array, int esq, int dir){
   if (esq < dir){
      int meio = (esq + dir) / 2;
      mergesortRec(array, esq, meio);
      mergesortRec(array, meio + 1, dir);
      intercalar(array, esq, meio, dir);
   }
}
//=============================================================================
void intercalar(int* array, int esq, int meio, int dir){

   //Definir tamanho dos dois subarrays
   int nEsq = (meio+1)-esq;
   int nDir = dir - meio;

   int* arrayEsq = (int*) malloc((nEsq+1) * sizeof(int)); 
   int* arrayDir = (int*) malloc((nDir+1) * sizeof(int));

   //Sentinela no final dos dois arrays
   arrayEsq[iEsq] = arrayDir[iDir] = 0x7FFFFFFF;

   int iEsq, iDir, i;

   //Inicializar primeiro subarray
   for(iEsq = 0; iEsq < nEsq; iEsq++){
      arrayEsq[iEsq] = array[esq+iEsq];
   }

   //Inicializar segundo subarray
   for(iDir = 0; iDir < nDir; iDir++){
      arrayDir[iDir] = array[meio+iDir+1];
   }

   //Intercalacao propriamente dita
   for(iEsq = iDir = 0, i = esq; i <= dir; i++){
      array[i] = (arrayEsq[iEsq] <= arrayDir[iDir]) ? arrayEsq[iEsq++] : arrayDir[iDir++];
   }
}
//=============================================================================
