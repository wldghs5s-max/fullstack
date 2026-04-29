import { useState } from "react";
import { join } from "../api/memberApi";

function useMemberJoin() {
    const initialState = {
        username: "",
        password: "",
        nick: "",
    };
    const [formData, setFormData] = useState(initialState);

    async function handleSubmit(evt) {
        evt.preventDefault();
        console.log(formData);
        const resp = await join(formData);
        return resp.status;
    }

    function handleChange(evt) {
        setFormData({ ...formData, [evt.target.name]: evt.target.value });
    }

    return { handleSubmit, handleChange, formData };
}

export default useMemberJoin;