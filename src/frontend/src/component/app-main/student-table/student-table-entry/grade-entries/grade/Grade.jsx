import "../GradeEntry.css"
import {Popover, OverlayTrigger} from "react-bootstrap";
import {Link} from "react-router-dom";

const Grade = ({grade}) =>{
    const descriptionPopover = (
        <Popover className={"grade-popover"}>
            <Popover.Header className={"grade-popover-header"}>
                Weight: {grade.weight}
            </Popover.Header>
            <Popover.Body>
                {grade.description}
            </Popover.Body>
        </Popover>
    )

    return <OverlayTrigger  trigger={['hover', 'focus']} placement={"bottom"} overlay={descriptionPopover} >
        <Link to={`/edit-grade-form/${grade.id}`}><div className={"grade-entry"}>{grade.value}</div></Link>
    </OverlayTrigger>
}
export {Grade}