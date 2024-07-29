
import React from 'react';
import { Typography, Container } from '@mui/material';
import Box from '@mui/material/Box';
//import IconButton from '@mui/material/IconButton';
//import Input from '@mui/material/Input';
//import FilledInput from '@mui/material/FilledInput';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
//import FormHelperText from '@mui/material/FormHelperText';
import FormControl from '@mui/material/FormControl';
import TextField from '@mui/material/TextField';
//import Visibility from '@mui/icons-material/Visibility';
//import VisibilityOff from '@mui/icons-material/VisibilityOff';

function ProfilePage() {
   
  
  return (
    <Container>
      <Typography variant="h4" component="h1" gutterBottom>
        Profile Page
      </Typography>
      <Typography variant="body1">
       profile information will be displayed

    <Box sx={{ display: 'flex', flexWrap: 'wrap' }}>
      <div>
        <TextField
          label="Required"
          id="outlined-start-adornment"
          sx={{ m: 1, width: '25ch' }}
          InputProps={{
            startAdornment: <InputAdornment position="start">Name</InputAdornment>,
          }}
        />
        <FormControl sx={{ m: 1, width: '25ch' }} variant="outlined">
          <OutlinedInput
            id="outlined-adornment-weight"
            endAdornment={<InputAdornment position="start">Middle Name</InputAdornment>}
            aria-describedby="outlined-Middle Name-helper-text"
            inputProps={{
              'aria-label': 'weight',
            }}
          />
          
        </FormControl>
        <FormControl sx={{ m: 1, width: '25ch' }} variant="outlined">
          <OutlinedInput
            id="outlined-adornment-weight"
            endAdornment={<InputAdornment position="start">Last Name</InputAdornment>}
            aria-describedby="outlined-Last Name-helper-text"
            inputProps={{
              'aria-label': 'Last Name',
            }}
          />
        
        </FormControl>
        <FormControl fullWidth sx={{ m: 1 }}>
          <InputLabel htmlFor="outlined-adornment-Email">Email</InputLabel>
          <OutlinedInput
            id="outlined-adornment-Email"
            startAdornment={<InputAdornment position="start"></InputAdornment>}
            label="Email"
          />
        </FormControl>
      </div>
          <div>
      <TextField
          label="Required"
          id="outlined-start-adornment"
          sx={{ m: 1, width: '25ch' }}
          InputProps={{
            startAdornment: <InputAdornment position="start">Mobile</InputAdornment>,
          }}
        />
        </div>
          
         <FormControl fullWidth sx={{ m: 1 }}>
          <InputLabel htmlFor="outlined-adornment-Address">Address</InputLabel>
          <OutlinedInput
            id="outlined-adornment-Address"
            startAdornment={<InputAdornment position="start"></InputAdornment>}
            label="Address"
          />
        </FormControl>
      
    </Box>
  

      </Typography>
    </Container>
  );
}

export default ProfilePage;
