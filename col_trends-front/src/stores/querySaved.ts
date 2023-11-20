import { defineStore } from 'pinia';
import { ref } from 'vue';

interface  UserQuerySave {
  idUserQuery?: number;
  userName?: String,
  comment?: String,
}

export const useQuerySavedStore = defineStore(
  'queryStore', () => {

    const querySaved = ref<UserQuerySave>({});
    const setQuery = (_query: UserQuerySave) => {
        querySaved.value = _query;
    }
    const setQueryValue = (_query: UserQuerySave) => {
        querySaved.value = {...querySaved.value ,..._query};
    }
    return {querySaved, setQuery, setQueryValue};
  }
);