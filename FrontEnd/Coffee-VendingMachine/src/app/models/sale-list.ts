import { Drink } from "./drink";

export class SaleList {
    saleListId: number;
    numberOfCup: number;
    date: Date;
    //_links : DrinkLink;
    drink: Drink = new Drink;
}
interface DrinkLink{
    "drink":{
        "href": string;
    }
}
