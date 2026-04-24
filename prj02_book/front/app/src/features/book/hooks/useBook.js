import { useDispatch, useSelector } from "react-redux";
import { selectAll, selectOne } from "../api/bookApi";
import { setError, setLoading, setVo, setVoList } from "../store/bookSilce";

function useBook() {
    const { voList, vo, loading, error } = useSelector((state) => state.book);
    const dispatch = useDispatch();

    async function fetchVoList() {
        try {
            dispatch(setLoading(true))
            dispatch(setError(null));
            const resp = await selectAll();
            dispatch(setVoList(resp.data));
        } catch (error) {
            dispatch(setError(error));
        } finally {
            dispatch(setLoading(false));
        }
    }

    async function fetchVoOne(id) {
        try {
            dispatch(setLoading(true))
            dispatch(setError(null));
            const resp = await selectOne(id);
            dispatch(setVo(resp.data));
        } catch (error) {
            dispatch(setError(error));
        } finally {
            dispatch(setLoading(false));
        }
    }

    return { fetchVoList, fetchVoOne, voList, vo, loading, error };
}

export default useBook;