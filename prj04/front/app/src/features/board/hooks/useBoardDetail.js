import { useState } from "react";
import api from "../../../app/api/axios";
import { selectOne } from "../api/boardApi";

export default function useBoardDetail() {
    const [vo, setVo] = useState(null);

    async function selectBoardOne(id) {
        const resp = await selectOne(id)
        setVo(resp.data);
    }



    return { vo, selectBoardOne };
}