import { connect } from "../../../../ardoq-packages/packages/rxbeach/src";
import { Person, person$ } from "./person$";

const PersonComponent = ({
    name,
    age,
    favColour} : Person) => {
        return(
            <div>
                <p>{name}</p>
                <p>{age}</p>
                <p>{favColour}</p>
            </div>
        )
    }

export default connect(PersonComponent, person$);
