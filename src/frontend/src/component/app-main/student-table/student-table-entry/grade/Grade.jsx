import "./Grade.css"
import {Popover, OverlayTrigger} from "react-bootstrap";

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
        <div className={"grade"}>{grade.value}</div>
    </OverlayTrigger>
}
export {Grade}