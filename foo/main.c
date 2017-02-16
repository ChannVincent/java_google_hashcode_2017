//
//  main.c
//  foo
//
//  Created by Vincent Chann on 13/02/2017.
//  Copyright © 2017 Smartapps. All rights reserved.
//

#include <stdio.h>

void readFile(){
    FILE* fichier = NULL;
    
    fichier = fopen("/Users/cdurif/Desktop/medium.txt", "r");
    
    if (fichier != NULL)
    {
        int nbLignes;
        int nbColones;
        int nbMin;
        int nbMax;
        
        int nbTomates = 0;
        int nbChampis = 0;
        
        fscanf(fichier, "%d %d %d %d", &nbLignes, &nbColones, &nbMin, &nbMax);
        
        printf("Nombre de lignes : %d\n", nbLignes);
        printf("Nombre de colonnes : %d\n", nbColones);
        printf("Nombre minimum de chaque ingrédient : %d\n", nbMin);
        printf("Nombre maximal de cases par part : %d\n", nbMax);
        
        int tab[nbLignes][nbColones];
        
        int i = 0;
        int j = 0;
        for(i=0; i<nbLignes; i++){
            for(j=0;j<nbColones;j++){
                char x = fgetc(fichier);
                
                if(x == '\n'){
                    x = fgetc(fichier);
                }
                
                int t = 4;
                if(x == 'T'){
                    t = 0;
                    nbTomates++;
                }
                else if(x == 'M'){
                    t = 1;
                    nbChampis++;
                }
                else{
                    
                }
                tab[i][j] = t;
            }
        }
        
        printf("La pizza contient %d tomates.\n", nbTomates);
        printf("La pizza contient %d champignons.\n", nbChampis);

        
        for(i=0; i<nbLignes; i++){
            for(j=0;j<nbColones;j++){
                printf("%d", tab[i][j]);
                if(j == nbColones-1){
                    printf("\n");
                }
            }
        }
        
        fclose(fichier);
    }
}

int isSliceValid(int *slice, int minIngredients, int sliceSize) {
    int tomatoeCount = 0;
    int mushroomCount = 0;
    
    for (int i = 0; i < sliceSize; i++) {
        if (slice[i] == 0) {
            tomatoeCount++;
        }
        else {
            mushroomCount++;
        }
    }
    
    if (tomatoeCount < minIngredients) {
        return 0;
    }
    else if (mushroomCount < minIngredients) {
        return 0;
    }
    else {
        return 1;
    }
}

void testIsSliceValid() {
    int slice[6] = {0,1,1,1,0,1};
    printf("is Slice valid : %d\n", isSliceValid(slice, 1, 6));
}

int main(int argc, const char * argv[]) {
    //testIsSliceValid();
    readFile();
    return 0;
}
