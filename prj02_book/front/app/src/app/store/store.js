import { configureStore } from "@reduxjs/toolkit";
import bookReducer from "../../features/book/store/bookSilce"

const store = configureStore({
    reducer: {
        book: bookReducer,
    },
});

export default store;