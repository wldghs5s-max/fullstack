import { useState } from "react";
import { selectList } from "../api/boardApi";
import { useParams } from "react-router-dom";

export default function useBoardList() {
    const [voList, setVoList] = useState([]);
    const [pageVo, setPageVo] = useState({
        startPage: 1,
        endPage: 5,
        currentPage: 1,
        pageLimit: 3,
    });
    const { pno } = useParams();
    async function asyncSelectList(condition) {
        const resp = await selectList(pno, condition);
        setVoList(resp.data.content);
        const { totalPages, number, first, last } = resp.data;

        const pageLimit = 3;
        const currentPage = number + 1;
        const startPage = Math.floor((currentPage - 1) / pageLimit) * pageLimit + 1;
        const endPage = Math.min(startPage + pageLimit - 1, totalPages);
        setPageVo({ startPage, endPage, currentPage, pageLimit, first, last });

    }



    return { voList, asyncSelectList, pageVo, pno };
}