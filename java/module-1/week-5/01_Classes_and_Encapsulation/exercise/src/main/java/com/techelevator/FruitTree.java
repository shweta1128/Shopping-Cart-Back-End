package com.techelevator;

public class FruitTree {
    private  String typeOfFruit ;
    private  int piecesOfFruitLeft ;

    public String getTypeOfFruit(){
        return this.typeOfFruit ;

    }
    public int getPiecesOfFruitLeft(){
        return  this.piecesOfFruitLeft;
    }


    public FruitTree (String typeOfFruit, int startingPieceOfFruits){
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = startingPieceOfFruits;

    }

    public boolean pickFruit (int numberOfPiecesToRemove  ){
        //int  remainingFruits ;


        //fruitLeft = pieceOfFruitLeft - numberOfPiecesToRemove;
        if (piecesOfFruitLeft < numberOfPiecesToRemove){
            return false;


        }
        piecesOfFruitLeft = piecesOfFruitLeft - numberOfPiecesToRemove;
        return true;

    }
}
