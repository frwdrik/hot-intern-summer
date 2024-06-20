import { Person } from "./person$";

const setName = (state : Person, newName : string) : Person => {
    return(
        {
            ...state,
            name: newName
        }
    )
}

const setAge = (state : Person, age : number) : Person => {
    return(
        {
            ...state,
            age
        }
    )
}

const setColour = (state : Person, favColour : string) : Person => {
    return(
        {
            ...state,
            favColour
        }
    )
}

export const operations = {
    setName,
    setAge,
    setColour,
}
