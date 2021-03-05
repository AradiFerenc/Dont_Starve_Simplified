package logic;

public enum Direction {
    UP {
        @Override
        public int xMovement()
        {
            return 0;
        }
        @Override
        public int yMovement()
        {
            return -1;
        }
        @Override
        public int getValue()
        {
            return 1;
        }
    },
    DOWN{
        @Override
        public int xMovement()
        {
            return 0;
        }
        @Override
        public int yMovement()
        {
            return 1;
        }
        @Override
        public int getValue()
        {
            return 0;
        }
    },
    LEFT{
        @Override
        public int xMovement()
        {
            return -1;
        }
        @Override
        public int yMovement()
        {
            return 0;
        }
        @Override
        public int getValue()
        {
            return 2;
        }
    },
    RIGHT{
        @Override
        public int xMovement()
        {
            return 1;
        }
        @Override
        public int yMovement()
        {
            return 0;
        }
        @Override
        public int getValue()
        {
            return 3;
        }

    };
    public abstract int xMovement();
    public abstract int yMovement();
    public abstract int getValue();
}
