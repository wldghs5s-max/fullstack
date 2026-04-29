import { useState } from "react";
import { login } from "../api/memberApi";

function useMemberLogin() {
    const initialState = {
        username: "",
        password: "",
    };
    const [formData, setFormData] = useState(initialState);

    async function handleSubmit(evt) {
        evt.preventDefault();
        console.log(formData);
        const resp = await login(formData);
        if (resp.status >= 200 && resp.status < 300) {
            localStorage.setItem("accessToken", resp.headers.authorization)
        }
        return resp.status;
    }

    function handleChange(evt) {
        setFormData({ ...formData, [evt.target.name]: evt.target.value });
    }

    return { handleSubmit, handleChange, formData };
}

export default useMemberLogin;
