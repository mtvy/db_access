package utils_test

import (
	"go_server/internal/service/utils"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestAnyToJson(t *testing.T) {

	t.Parallel()

	var testCase = []interface{}{
		"hello", 100, 3.14, true, []int{1, 2, 3}, map[string]string{"foo": "bar"},
	}

	t.Run("Json Convert", func(t *testing.T) {
		jsonData, err := utils.AnyToJson(testCase)
		require.NoError(t, err)
		require.EqualValues(t, "[\"hello\",100,3.14,true,[1,2,3],{\"foo\":\"bar\"}]", string(jsonData))
	})
}
