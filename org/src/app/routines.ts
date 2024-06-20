import { collectRoutines, dispatchAction, ofType, routine } from "../../../../ardoq-packages/packages/rxbeach/src";
import { map, tap } from "rxjs/operators";

const getRandomColour = () => {
    const colours = ["Red", "Yellow", "Green", "Orange"];
    return colours[Math.floor(Math.random()*colours.length)];
}
