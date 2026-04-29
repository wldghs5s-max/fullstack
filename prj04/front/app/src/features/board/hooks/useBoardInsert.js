import { useState } from "react";
import { insert } from "../api/boardApi";

export default function useBoardInsert() {

    const initialState = {
        title: '',
        content: '',
    };
    const [formData, setFormData] = useState(initialState);
    function handleChange(e) {
        const { name, value } = e.target;
        setFormData((prev) => ({ ...prev, [name]: value }));
    }
    async function handleSubmit(e) {
        e.preventDefault();
        const resp = await insert(formData);
        setFormData(initialState);
        alert(resp.status);
    }

    return { handleChange, handleSubmit, formData };
}