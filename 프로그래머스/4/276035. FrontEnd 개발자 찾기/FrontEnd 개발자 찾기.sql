# JavaScript = b'10000'
# React = b'100000000000'
# Vue = b'10000000000000'
# Front End = b'10100000010000'

# FrontEnd 스킬 전부 다 더하기
# SELECT SUM(CODE)
# FROM SKILLCODES
# WHERE CATEGORY = 'Front End';

SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
# b'10100000010000' 이랑 비트연산 해서 1이 나오면 Front End 스킬을 보유하고있다는 뜻
WHERE SKILL_CODE & (
        SELECT SUM(CODE)
        FROM SKILLCODES
        WHERE CATEGORY = 'Front End'
    )
ORDER BY ID ASC;