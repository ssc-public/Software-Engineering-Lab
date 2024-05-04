from django import forms
from .models import CustomUser


class UserCreateForm(forms.ModelForm):
    class Meta:
        model = CustomUser
        fields = ['username', 'password']

    def save(self):
        user: CustomUser = super().save(commit=False)
        user.set_password(self.cleaned_data['password'])
        user.save()
        return user
