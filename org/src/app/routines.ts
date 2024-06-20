import { collectRoutines, dispatchAction, ofType, routine } from "../../../../ardoq-packages/packages/rxbeach/src";
import { tap } from "rxjs/operators";
import { getColour, setColour } from "./actions";
import { switchMap } from "rxjs";

const getRandomColour = async () => {
    const colours = ["Red", "Yellow", "Green", "Orange"];
    return colours[Math.floor(Math.random()*colours.length)];
}

const handleGetColour = routine(
    ofType(getColour),
    switchMap(getRandomColour),
    tap(colour => {
        dispatchAction(setColour(colour));
    })
)

export const routines = collectRoutines(
    handleGetColour,
)
