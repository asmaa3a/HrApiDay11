package org.example.DTO;

import jakarta.ws.rs.QueryParam;

public class JobfilterDto {

        private @QueryParam("min_salary") Integer min_salary;
        private @QueryParam("limit") Integer limit;
        private @QueryParam("offset") int offset;

        public Integer getMin_salary() {
            return min_salary;
        }

        public void setMin_salary(Integer min_salary) {
            this.min_salary = min_salary;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }
}
