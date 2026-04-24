import { createSlice } from "@reduxjs/toolkit";

const bookSlice = createSlice({
    name: "book",
    initialState: {
        voList: [],
        vo: {},
        loading: false,
        error: null,
    },
    reducers: {
        setVoList: (state, action) => {
            state.voList = action.payload;
        },
        setVo: (state, action) => {
            state.vo = action.payload;
        },
        setLoading: (state, action) => {
            state.loading = action.payload;
        },
        setError: (state, action) => {
            state.error = action.payload;
        },
        reset: () => initialState,
    },
});
export const { setError, setLoading, setVo, setVoList, reset } = bookSlice.actions;
export default bookSlice.reducer;
